package com.ming.data.mapper;

import com.ming.data.entity.BuildClass;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MqttMapper {
    int updateClass(int classid, String classtype, String classnumber, String datakey, String datavalue, String time);

    List<BuildClass> selectData(String classtype, String classnumber);


}
