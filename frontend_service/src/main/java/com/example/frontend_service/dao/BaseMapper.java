package com.example.frontend_service.dao;

import com.example.frontend_service.entity.Base;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
public interface BaseMapper {
    /******************Required Interfaces****************/
    @Select("select * from base where id = #{id} and is_deleted = 0")
    Base getById(Long id);

    @Select("select * from base where id = #{id}")
    Base abstractById(Long id);

    Integer update(Base base);

    Integer insert(Base base);

    @Update("update base set is_deleted = 1 where id = #{id}")
    Integer delete(Integer id);

    /******************Other Interfaces****************/
}
