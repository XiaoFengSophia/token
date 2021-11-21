package com.zxf.controller;


import com.zxf.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("buiss")
public class TestJWTController {

    @Autowired
    private ILoginService loginService;

    @GetMapping("/getMsg")
    public String getMsg(){

        return loginService.getMsg();
    }
}
