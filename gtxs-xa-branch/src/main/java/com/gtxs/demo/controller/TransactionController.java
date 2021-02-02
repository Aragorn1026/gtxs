package com.gtxs.demo.controller;

import com.gtxs.demo.pojo.Dept;
import com.gtxs.demo.service.DeptTransaXaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("transa")
public class TransactionController {


    @Autowired
    DeptTransaXaService deptTransaXaService;

    @PostMapping("xa/add")
    public void TransactionXaMode(Dept dept){
//      本地事务，当前不记入gtxs日志
        deptTransaXaService.addDept(dept);
    }
}