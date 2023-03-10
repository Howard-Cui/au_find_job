package com.example.frontend_controller.VO;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PositionDetailVO {
    private Long positionId;
    private String title;
    private String companyName;
    private String salary;
    private String images;
    private String base;
    private String description;
    private String tags;

}
