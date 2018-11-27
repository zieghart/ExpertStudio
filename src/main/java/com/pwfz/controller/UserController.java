package com.pwfz.controller;

import com.pwfz.entity.ModuleItem;
import com.pwfz.entity.User;
import com.pwfz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index(){
        List<ModuleItem> moduleItems = userRepository.findAllModuleById(1);
        for (ModuleItem moduleItem:moduleItems){
            System.out.println("module:type-"+moduleItem.getType());
        }
//        for(User user:userRepository.findAll()){
//            System.out.println("user:name-"+user.getUsername());
//        }
        return "index";
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(){
        User user = new User("冯天祥","123");
        return "success";
    }
}
