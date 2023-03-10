package com.example.frontend_controller.VO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PositionVO {
    private Long id;
    private String title;
    private String coverImgUrl;
    private String companyName;
    private String salary;
    private String base;
    private String description;
    private List<String> tags;
}
