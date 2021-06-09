package com.easy.archiecture.controller;

import com.easy.archiecture.entity.Person;
import com.easy.archiecture.service.PersonServiceImpl;
import com.easy.archiecture.support.JWTUtil;
import jdk.nashorn.internal.runtime.arrays.IteratorAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {
    @Autowired
    private PersonServiceImpl personService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public String login(String username,String password){
        Person person=new Person();
        if (person==null||person.getName()==null){
            return "用户不存在或用户名、密码错误";
        }
        String sign= JWTUtil.sign(person,60L * 1000L * 30L);
        return "hello"+person.getName()+"token:"+sign;
    }

    @RequestMapping(value = "logon",method = RequestMethod.POST)
    @ResponseBody
    public String logon(String username,int age,String password){
        if (username==null||password==null||age==0){
            return "用户名和密码不能为空";
        }
        Person person=new Person(username,age,password);
        personService.insertPerson(person);
        return person.getName()+"添加成功";
    }

    @RequestMapping(value = "registry", method = RequestMethod.POST)
    @ResponseBody
    public String registry(Person person){
        boolean register=personService.register(person);
        if (register){
            return "holle"+ person.getName();
        }
        return "注册失败";
    }
}
