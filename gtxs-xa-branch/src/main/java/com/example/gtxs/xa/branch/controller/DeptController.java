package com.example.gtxs.xa.branch.controller;

import com.example.gtxs.xa.branch.pojo.Dept;
import com.example.gtxs.xa.branch.service.DeptMapperService;
import com.netease.cloud.gtxs.core.annotation.GtxsXATransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DeptMapperService deptMapperService;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptMapperService.addDept(dept);
    }


    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Integer id){
        return deptMapperService.queryById(id);
    }

    @GetMapping ("/dept/list")
    public List<Dept> queryAll(){
        return deptMapperService.queryAll();
    }

    @GetMapping("/dept/query")
    public List<Dept> query(){ return deptMapperService.query(); }

    @GetMapping ("/dept/delete/{id}")
    public boolean deleteDept(@PathVariable("id") Integer id){
        return deptMapperService.deleteDept(id);
    }

    @GetMapping("/dept/descdeptno")
    public Integer descDeptno() {
        return deptMapperService.descDeptno();
    }

}
