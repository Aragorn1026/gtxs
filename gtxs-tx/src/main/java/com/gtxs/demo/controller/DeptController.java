package com.gtxs.demo.controller;

import com.gtxs.demo.dao.DeptDao;
import com.gtxs.demo.pojo.Dept;
import com.gtxs.demo.service.DeptMapperService;
import com.gtxs.demo.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping ("/dept/delete/{id}")
    public boolean deleteDept(@PathVariable("id") Integer id){
        return deptMapperService.deleteDept(id);
    }

    @GetMapping("/dept/descdeptno")
    public Integer descDeptno() { return deptMapperService.descDeptno();
    }

}
