package com.gtxs.demo.controller;

import com.gtxs.demo.pojo.Dept;
import com.gtxs.demo.service.DeptMapperService;
import com.gtxs.demo.service.DeptTransaSagaService;
import com.gtxs.demo.service.DeptTransaTccService;
import com.netease.cloud.gtxs.common.enums.TxMode;
import com.netease.cloud.gtxs.core.annotation.GtxsTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transa")
public class TransactionController {

    @Autowired
    DeptMapperService deptMapperService;

    @Autowired
    DeptTransaTccService deptTransaTccService;

    @Autowired
    DeptTransaSagaService deptTransaSagaService;

    @PostMapping("fmt/add")
    @GtxsTransaction(name = "fmtbranch")
    @Transactional(rollbackFor = Exception.class)
    public void TransactionFmtMode(Dept dept){
        deptMapperService.addDept(dept);
        System.out.println("gtxs fmt branch comfirm");
//        throw new RuntimeException("gtxs fmt mode 测试报个错");
    }

    @PostMapping("tcc/add")
    public void TransactionTccMode(Dept dept){
        deptTransaTccService.dotry(dept);
    }

    @PostMapping("saga/add")
    public void TransactionSagaMode(Dept dept){
        deptTransaSagaService.dotry(dept);
    }

}
