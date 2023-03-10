package com.example.frontend_service.dao;

import com.example.frontend_service.entity.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface PositionMapper {
    /******************Required Interfaces****************/
    @Select("select * from position where id = #{id} and is_deleted = 0")
    Position getById(Long id);

    @Select("select * from position where id = #{id}")
    Position abstractById(Long id);

    Integer update(Position position);

    Integer insert(Position position);

    @Update("update position set is_deleted = 1 where id = #{id}")
    Integer delete(Integer id);

    /******************Other Interfaces****************/
    @Select("SELECT * FROM position WHERE is_deleted = 0 ORDER BY `id` ASC" +
            " LIMIT #{page}, #{numInPage} ")
    List<Position> getPositionList(Integer page, Integer numInPage);

    @Select("SELECT COUNT(*) FROM position WHERE is_deleted = 0")
    Integer getTotalNumOfPosition();
}
