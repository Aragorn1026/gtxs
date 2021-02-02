package com.gtxs.demo.service;

import com.gtxs.demo.pojo.Dept;

public interface DeptTransaSagaService {
    public String dotry(Dept dept);
    public Boolean cancel(Dept dept);
}
