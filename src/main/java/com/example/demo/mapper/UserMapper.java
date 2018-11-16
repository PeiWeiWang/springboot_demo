package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from t_user")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    List<User> queryAll();

    @Delete("delete from t_user where id = #{id}")
   int deletUser(int id);

     @Insert("insert into t_user(name) values (#{name})")
    int addUser(User user);

     @Select("select * from t_user where id = #{id}")
     @Results({
             @Result(property = "id",column = "id"),
             @Result(property = "name",column = "name")
     })
    User getUserById(int id);

     @Update("update t_user set name = #{name} where id = #{id}")
    int updateUser(User user);
}
