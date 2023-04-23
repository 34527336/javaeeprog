package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    @Select("select * from user where id=#{id}")
    User getById(int id);
}
