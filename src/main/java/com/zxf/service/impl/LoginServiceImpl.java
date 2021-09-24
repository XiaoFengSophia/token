package com.zxf.service.impl;

import com.zxf.dao.ILoginDao;
import com.zxf.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/7/13 17:42
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private ILoginDao loginDao;
    @Override
    public String getMsg() {

        return loginDao.getMsg();
    }
}
