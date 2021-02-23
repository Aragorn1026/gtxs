package com.example.gtxs.branch.service;

import com.example.gtxs.branch.pojo.Dept;

public interface DeptTransaSagaService {
    public String dotry(Dept dept);
    public Boolean cancel(Dept dept);
}
