package com.service.impl;

import com.dao.BookDao;
import com.pojo.Book;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Book getById(int id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll(Book book) {
        if (book.getPage()!=null)
        book.setPage((book.getPage()-1)*book.getPagesize());
        else
        book.setPage(0);
        return bookDao.getAll(book);
    }

    @Override
    public int save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public int edit(Book book) {
        return bookDao.edit(book);
    }

    @Override
    public int deleteById(int id) {
        return bookDao.deleteById(id);
    }

    @Override
    public Integer getCount(Book book) {

        return bookDao.getCount(book);
    }
}
