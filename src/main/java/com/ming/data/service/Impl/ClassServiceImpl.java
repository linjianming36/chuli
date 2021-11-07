package com.ming.data.service.Impl;

import com.ming.data.entity.BuildClass;
import com.ming.data.mapper.MqttMapper;
import com.ming.data.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    MqttMapper mqttMapper;
    @Override
    public int updateClass(int classid,String classtype, String classnumber, String datakey,String datavalue, String time){
        return  mqttMapper.updateClass(classid,classtype, classnumber, datakey,datavalue, time);
    }

    @Override
    public List<BuildClass> selectData(String classtype, String classnumber) {
        return mqttMapper.selectData(classtype, classnumber);
    }

}
