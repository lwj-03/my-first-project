package com.stbu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stbu.controller.bean.MyUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class JsonController {

    @RequestMapping("/testObjJson")
    public String testJson() throws JsonProcessingException {
        MyUser myUser=new MyUser();
        myUser.setId(1);
        myUser.setUsername("admin11");
        myUser.setPassword("123456");
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(myUser);
    }

    @RequestMapping("/testList")
    public String testListJson() throws JsonProcessingException {
        List<MyUser> myList=new ArrayList<MyUser>();
        MyUser myUser=new MyUser();
        myUser.setId(1);
        myUser.setUsername("admin11");
        myUser.setPassword("123456");
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(myUser);
    }
}
