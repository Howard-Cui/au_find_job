package com.example.frontend_controller.VO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PositionListVO {
    private Boolean isEnd;
    private List<PositionVO> positionList;
}
