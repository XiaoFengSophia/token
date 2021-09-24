package com.zxf.dao.impl;

import com.zxf.dao.ILoginDao;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/7/13 17:44
 */
@Repository
public class LoginDaoImpl implements ILoginDao {
    @Override
    public String getMsg() {

        return "This is a success request !";
    }
}
