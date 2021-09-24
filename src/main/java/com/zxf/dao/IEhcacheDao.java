package com.zxf.dao;

import org.springframework.cache.annotation.Cacheable;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/12/19 15:14
 */
public interface IEhcacheDao {

    @Cacheable
    String findByName(String name);
}
