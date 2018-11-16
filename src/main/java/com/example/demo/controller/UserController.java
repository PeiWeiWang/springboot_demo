package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;



@Controller
public class UserController {

    @Resource
     UserService userService;

    @RequestMapping("/query")
    @ResponseBody
    public String queryUser()
    {
        JSONObject jsonObject =new JSONObject();
        List<User> userList = new ArrayList<>();
        try {
        userList = userService.querAll();
        jsonObject.put("userList",userList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toJSONString();
    }

    @RequestMapping("/delete")
    public String delete( int id){
        try {
            boolean deleteBoolean = userService.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "userList.html";
    }

    @RequestMapping("/toUpdate")
    @ResponseBody
    public  String toUpdateUser(int id){
        JSONObject json = new JSONObject();
        try {
            User user = userService.getUserById(id);
            json.put("user",user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json.toJSONString();
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(User user){
        JSONObject json = new JSONObject();
        try {
            boolean updateBoolean = userService.updateUser(user);
            json.put("status",200);
        } catch (Exception e) {
            json.put("status",500);
            json.put("msg","系统正在维护，请稍后再试~");
            e.printStackTrace();
        }
        return json.toJSONString();
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(User user){
            JSONObject json = new JSONObject();
            try {
                boolean addBoolean = userService.addUser(user);
                json.put("status",200);
            } catch (Exception e) {
                json.put("status",500);
                json.put("msg","系统正在升级，请稍后再试~");
                e.printStackTrace();
            }
            return json.toJSONString();
        }
}
