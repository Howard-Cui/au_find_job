package com.example.frontend_service.service;

import com.example.frontend_service.dao.BaseMapper;
import com.example.frontend_service.entity.Base;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {
    @Resource
    private BaseMapper baseMapper;

    public String getBaseById(Long id) {

        Base base = baseMapper.getById(id);
        String result = base.getBaseCity() + ", " + base.getBaseState();
        return result;
    }
}
