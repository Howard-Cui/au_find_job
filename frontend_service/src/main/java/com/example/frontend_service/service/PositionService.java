package com.example.frontend_service.service;

import com.example.frontend_service.dao.PositionMapper;
import com.example.frontend_service.entity.Position;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    @Resource
    private PositionMapper positionMapper;

    public List<Position> getPositionList(Integer page, Integer pageSize) {

        return positionMapper.getPositionList(page * 10 - 10, pageSize);
    }

    public Integer getNumOfPosition() {
        return positionMapper.getTotalNumOfPosition();
    }

    public Position getPositionById(Long id) {
        return positionMapper.getById(id);
    }

}
