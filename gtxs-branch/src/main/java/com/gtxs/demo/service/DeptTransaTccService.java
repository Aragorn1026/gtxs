package com.gtxs.demo.service;

import com.gtxs.demo.pojo.Dept;

public interface DeptTransaTccService {

    public String dotry(Dept dept);
    public Boolean confirm(Dept dept);
    public Boolean cancel(Dept dept);

}
