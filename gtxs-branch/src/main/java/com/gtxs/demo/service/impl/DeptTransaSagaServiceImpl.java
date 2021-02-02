package com.gtxs.demo.service.impl;

import com.gtxs.demo.dao.DeptDao;
import com.gtxs.demo.pojo.Dept;
import com.netease.cloud.gtxs.core.annotation.CompensableBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptTransaSagaServiceImpl implements com.gtxs.demo.service.DeptTransaSagaService{
    @Autowired
    private DeptDao deptDao;

    @Override
    @CompensableBranch(name = "sagabranch", compensateMethod = "cancel")
    public String dotry(Dept dept){

        deptDao.addDept(dept);
        return ("saga 参与者 comfirm");
    }

    @Override
    public Boolean cancel(Dept dept){
        System.out.println("saga 参与者 cancel");
        int descdeptno = deptDao.descDeptno();
        deptDao.deleteDept(descdeptno);
        return true;
    }
}
