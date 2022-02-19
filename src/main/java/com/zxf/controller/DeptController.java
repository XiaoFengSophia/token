package com.zxf.controller;

import com.zxf.entities.OptResult;
import com.zxf.service.DeptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private DeptService deptService;

    @GetMapping("/listDept")
    public OptResult listDept(){

        return deptService.listDept();
    }
}
