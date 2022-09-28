package com.test.mapper;

import com.test.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<UserEntity> select();

    @Select("select * from user limit #{page}, #{pageSize}")
    List<UserEntity> selectPage(@Param("page") int page, @Param("pageSize")int pageSize);

    @Select("select count(*) from user")
    int count();

    @Insert("insert into user(username,password) values(#{username},#{password})")
    boolean insert(@Param("username") String userName, @Param("password") String password);

}
