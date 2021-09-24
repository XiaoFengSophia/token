package com.zxf.controller;

import com.zxf.jwttoken.JwtToken;
import com.zxf.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/3/25 11:35
 */
@RestController
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @RequestMapping("/login")
    public String login() throws Exception {

        return JwtToken.creatToken();
    }
    @GetMapping("getMsg")
    public String getMsg(){

        return loginService.getMsg();
    }
}
