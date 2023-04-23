package com.dao;

import com.pojo.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookDao {
    @Select("select * from book where id=#{id}")
    Book getById(int id);
    //@Select("select * from book where name like '%#{name}%' and type=#{type} and description=#{description} ")
    List<Book> getAll(Book book);
    @Insert("insert into book (type,name,description) values (#{type},#{name},#{description})")
    int save(Book book);
    @Update("update  book set type=#{type},name=#{name},description=#{description} where id=#{id}")
    int edit(Book book);
    @Delete("delete from book where id=#{id}")
    int deleteById(int id);
    //@Select("select count(*) from book")
    Integer getCount(Book book);

}
