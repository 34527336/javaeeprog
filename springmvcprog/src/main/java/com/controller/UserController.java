package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //以JSON形式传值
    @PostMapping
    @ResponseBody
    public String save(@RequestBody User user){
        System.out.println("save"+user.toString());
    return "success";
    }

    //以POST表单形式传值
    /*@PostMapping
    @ResponseBody
    public String save( User user){
        System.out.println("save"+user.toString());
        return "success";
    }*/

    @GetMapping("/{id}")
    @ResponseBody
    public User getById(@PathVariable int id){
        System.out.println("getUser");
        System.out.println(id);
        return userService.getById(id);
    }
    @GetMapping
    @ResponseBody
    public String getAll(){
        System.out.println("getAll");
        return "success";
    }

    @PutMapping
    @ResponseBody
    public String update(@RequestBody User user){
        System.out.println("editUser:"+user.toString());
        return "success";
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public String delete(@PathVariable int id){
        System.out.println("delUser:"+id);
        return "success";
    }

}
