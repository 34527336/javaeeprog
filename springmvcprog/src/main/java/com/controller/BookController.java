package com.controller;

import com.pojo.Book;
import com.service.BookService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;


    public Book getById(int id) {
        return bookService.getById(id);
    }

    @PostMapping("/getAll")
    @ResponseBody
    public  Map<String ,Object> getAll(@RequestBody Book book) {
        System.out.println(book);

        List<Book>datalist=bookService.getAll(book);
        Integer total = bookService.getCount(book);
        Map<String ,Object> map=new HashMap<>();
        map.put("data",datalist);
        map.put("total",total);
        System.out.println(datalist);
        return map;
    }
    @PostMapping
    @ResponseBody
    public String save(@RequestBody  Book book) {
        return bookService.save(book)>=1?"success":"fail";
    }
    @PutMapping
    @ResponseBody
    public String edit(@RequestBody Book book) {
        return bookService.edit(book)>=1?"success":"fail";
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteById(@PathVariable int id) {
        return bookService.deleteById(id)>=1?"success":"fail";
    }

    @GetMapping("/getCount")
    @ResponseBody
    public Integer getCount(Book book) {
        return bookService.getCount(book)!=null?bookService.getCount(book):0;
    }

}
