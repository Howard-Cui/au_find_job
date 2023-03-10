package com.example.frontend_service.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Base {
    private Long id;
    private String baseCity;
    private String baseState;
    private Integer createTime;
    private Integer updateTime;
    private Boolean isDeleted;
}
