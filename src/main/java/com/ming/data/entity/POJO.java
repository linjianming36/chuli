package com.ming.data.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class POJO {
    String classnumber;
    String percent;
    int classid;
    String time;
    String classtype;


}
