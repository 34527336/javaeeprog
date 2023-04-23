package com.service;

import com.pojo.Book;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface BookService {
    Book getById(int id);
    List<Book> getAll(Book book);
    int save(Book book);
    int edit(Book book);
    int deleteById(int id);
    Integer getCount(Book book) ;
}
