package com.gtxs.demo.service.impl;

import com.gtxs.demo.dao.DeptDao;
import com.gtxs.demo.pojo.Dept;
import com.netease.cloud.gtxs.core.annotation.ReservableBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptTransaTccServiceImpl implements com.gtxs.demo.service.DeptTransaTccService{

    @Autowired
    private DeptDao deptDao;

    @Override
    @ReservableBranch(name = "tccbranch", confirmMethod = "confirm" , cancelMethod = "cancel")
    public String dotry(Dept dept){
        deptDao.addDept(dept);
        System.out.println("tcc 参与者 try");
        return "tcc 参与者 try ";
    }

    @Override
    public Boolean confirm(Dept dept){
        System.out.println("tcc 参与者 confirm");
        return deptDao.addDept(dept);
    }

    @Override
    public Boolean cancel(Dept dept){
        int descdeptno = deptDao.descDeptno();
        deptDao.deleteDept(descdeptno);
        System.out.println("tcc 参与者 cancel");
        return true;
    }
}
