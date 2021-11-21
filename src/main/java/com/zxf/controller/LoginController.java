package com.zxf.controller;

import com.alibaba.fastjson.JSONObject;
import com.zxf.entities.Result;
import com.zxf.service.ILoginService;
import com.zxf.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/3/25 11:35
 */
@RestController
public class LoginController {

    @Autowired
    private JwtUtils jwtToken;

    @Autowired
    private ILoginService loginService;

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream outputStream = response.getOutputStream();

        String jwt = jwtToken.creatToken();
        response.setHeader(jwtToken.getHeader(), jwt);
        System.out.println("jwt = " + jwt);
        Result result = Result.succ("");
        outputStream.write(JSONObject.toJSONString(result).getBytes("UTF-8"));

        outputStream.flush();
        outputStream.close();
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream outputStream = response.getOutputStream();

        response.setHeader(jwtToken.getHeader(), "");

        Result result = Result.succ(200, "退出成功！", null);
        outputStream.write(JSONObject.toJSONString(result).getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }

}
