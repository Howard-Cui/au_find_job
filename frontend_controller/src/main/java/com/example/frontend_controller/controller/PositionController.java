package com.example.frontend_controller.controller;

import com.example.frontend_controller.VO.PositionDetailVO;
import com.example.frontend_controller.VO.PositionListVO;
import com.example.frontend_controller.VO.PositionVO;
import com.example.frontend_service.entity.Base;
import com.example.frontend_service.entity.Position;
import com.example.frontend_service.service.BaseService;
import com.example.frontend_service.service.PositionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PositionController {
    @Resource
    private PositionService positionService;
    @Resource
    private BaseService baseService;

    private Integer NUM_IN_PAGE = 10;

    @RequestMapping("/position/frontend/list")
    public PositionListVO getPositionList(@RequestParam("page") Integer page) {
        PositionListVO positionListVO = new PositionListVO();
        List<PositionVO> positionVOList = new ArrayList<>();

        List<Position> positionList = positionService.getPositionList(page, NUM_IN_PAGE);

        Integer largestId = 0;

        for (Position p: positionList) {
            largestId = (largestId < p.getId().intValue())? p.getId().intValue() : largestId;


            PositionVO positionVO = new PositionVO();
            positionVO.setId(p.getId());
            positionVO.setTitle(p.getTitle());

            String coverImg = p.getImgSets().split("$")[0];
            positionVO.setCoverImgUrl(coverImg);
            positionVO.setCoverImgUrl(p.getCompany());
            positionVO.setSalary(p.getSalary());

            //handle mapper
            String base = baseService.getBaseById(p.getBaseId());
            positionVO.setBase(base);
            positionVO.setDescription(p.getDescribe());
            positionVO.setTags(Arrays.stream(p.getTagSets().split("$")).toList());

            positionVOList.add(positionVO);
        }

        positionListVO.setIsEnd(largestId == positionService.getNumOfPosition());

        positionListVO.setPositionList(positionVOList);

        return positionListVO;
    }

    @RequestMapping("/position/frontend/Detail")
    public PositionDetailVO getPositionDetail(
            @RequestParam("positionId") Long positionId) {
        PositionDetailVO positionDetailVO = new PositionDetailVO();

        Position position = positionService.getPositionById(positionId);
        String base = baseService.getBaseById(position.getBaseId());

        positionDetailVO.setBase(base);

        positionDetailVO.setPositionId(position.getId());
        positionDetailVO.setTags(position.getTagSets());
        positionDetailVO.setSalary(position.getSalary());
        positionDetailVO.setTitle(position.getTitle());
        positionDetailVO.setCompanyName(position.getCompany());
        positionDetailVO.setImages(position.getImgSets());
        positionDetailVO.setDescription(position.getDescribe());

        return positionDetailVO;
    }
}
