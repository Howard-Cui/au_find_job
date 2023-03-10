package com.example.frontend_service.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Position {
    private Long id;
    private String title;
    private String salary;
    private String describe;
    private Long baseId;
    private String company;
    private String imgSets;
    private String tagSets;
    private Integer createTime;
    private Integer updateTime;
    private Boolean isDeleted;
}
