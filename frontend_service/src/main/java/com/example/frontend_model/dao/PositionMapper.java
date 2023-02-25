package com.example.frontend_model.dao;

import com.example.frontend_model.entity.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PositionMapper {
    @Select("select * from position where id = #{id} and isDeleted = 0")
    Position getById(Long id);

    @Select("select * from position where id = #{id}")
    Position abstractById(Long id);

    Integer update(Position position);

    Integer insert(Position position);

    @Update("update position set is_deleted = 1 where id = #{id}")
    Integer delete(Integer id);
}
