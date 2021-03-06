package com.example.gtxs.xa.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors //链式写法
public class Dept implements Serializable {
    private Integer deptno; //主键
    private Integer length;
    private String dname;
    //这个数据存在哪个数据库的字段,一个微服务可以对应一个数据库；同一个信息可能存在不同的数据库
    private String dbsource;

    //注册构造器
    public Dept(String dname) {
        this.dname = dname;
    }
}
