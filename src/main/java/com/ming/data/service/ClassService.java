package com.ming.data.service;

import com.ming.data.entity.BuildClass;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ClassService {
    int updateClass(int classid, String classtype, String classnumber, String datakey, String datavalue, String time);

    List<BuildClass> selectData(String classtype, String classnumber);
}
