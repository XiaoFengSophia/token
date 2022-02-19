package com.zxf.service.impl;

import com.zxf.entities.Dept;
import com.zxf.entities.OptResult;
import com.zxf.mapper.DeptMapper;
import com.zxf.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    public OptResult listDept() {
        OptResult result = new OptResult();
        List<Dept> depts = deptMapper.listDept();
        result.setCode("1");
        result.setMsg("操作成功！");
        result.setData(depts);
        return result;
    }

}
