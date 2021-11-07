package com.ming.data.mqtt;


import com.alibaba.fastjson.JSONObject;
import com.ming.data.service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Slf4j
@Component
public class Callback implements MqttCallback{

    /*@Autowired
    private ClassService classService;*/
    public static String test1(String msg){
        return removeCharAt1(msg);

    }
    public static String removeCharAt1(String s){
        return s.substring(0, 3);
    }
    public static String test2(String msg){

        return removeCharAt2(msg);

    }
    public static String removeCharAt2(String s){
        String a = s.substring(0, 9);
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(a);
        String str = m.replaceAll("").trim();
        return str;
    }


    public static String test(String msg){
        return removeCharAt(msg);

    }
    public static String removeCharAt(String s){
        String msg1 = s.substring(1);
        String msg2= msg1.replace("[","");
        String msg3 = msg2.replace("]","");
        String msg4 = msg3.substring(5,msg3.length()-1);
        String msg5 = msg4.replaceAll(" ","");
        return msg5;
    }

    public static int ming(String classtype){



        if (classtype.equals("北主楼")){
            return 1;
        }
        else if (classtype.equals("马兰芳")){
            return 2;
        }
        else
            return 3;


    }


    @Override
    public void connectionLost(Throwable throwable) {
        log.info("断开了MQTT连接 ：{}", throwable.getMessage());
        log.error(throwable.getMessage(), throwable);
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        //  TODO    此处可以将订阅得到的消息进行业务处理、数据存储
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取当前时间String类型
        String time_string = sdf.format(date);


        log.info("收到来自 " + topic + " 的消息: {}", new String(message.getPayload()));


        String shuju = test(new String(message.getPayload()));



        JSONObject object= JSONObject.parseObject(shuju);
        JSONObject mm1 = object.getJSONObject("dvl");
        JSONObject mm2 = mm1.getJSONObject("dl");
        Set<String> mm3 =mm2.keySet();
        String mm4 =String.valueOf(mm3);
        String mm5= mm4.replace("[","");
        String mm6 = mm5.replace("]","");
        String mm7 = mm2.getString(mm6);
        String mm8 = mm6.substring(3);
        String mm9 = mm8.replaceAll("\\d","");
        String classtype = test1(mm6);
        String classnumber = test2(mm6);


        int classid = ming(classtype);
        System.out.println(classid);
        System.out.println(classtype);
        System.out.println(classnumber);
        System.out.println(mm6);
        System.out.println(mm9);
        System.out.println(mm7);
        ApplicationContext context = SpringUtil.context;  //获取Spring容器
        ClassService s = context.getBean(ClassService.class);
        s.updateClass(classid,classtype,classnumber,mm9,mm7,time_string);
        /*s.updateClass("黄浩川201课室满座率",time_string);*/
    }
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        log.info("发布消息成功");
    }
}
