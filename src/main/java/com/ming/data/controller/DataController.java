package com.ming.data.controller;

import com.ming.data.entity.BuildClass;
import com.ming.data.mapper.MqttMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {
    @Autowired
    MqttMapper mqttMapper;
    @RequestMapping(value = "/ming/calldata",method = RequestMethod.POST)
    public List<BuildClass> CallData(@RequestBody DataParms dataParms ){

        return mqttMapper.selectData(dataParms.classtype,dataParms.classnumber);
    }


}
@Data
@AllArgsConstructor
@NoArgsConstructor

class DataParms{
    String classtype;
    String classnumber;
}