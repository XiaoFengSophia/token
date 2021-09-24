package com.zxf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/11/1 18:48
 */
@RestController
public class TestLogController {

    @RequestMapping("/testLog")
    public String testLog(String param) throws Exception {
//        int i = 2;
//        int k = 0;
//        double c = i/k;

        return "This is test log !!!" + param;
    }

}
