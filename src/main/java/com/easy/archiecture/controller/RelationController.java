package com.easy.archiecture.controller;

import com.easy.archiecture.entity.Person;
import com.easy.archiecture.entity.Relation;
import com.easy.archiecture.service.PersonServiceImpl;
import com.easy.archiecture.service.RelationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RelationController {
    @Autowired
    private RelationServiceImpl relationService;

    @Autowired
    private PersonServiceImpl personService;

    @RequestMapping(value = "addrelation",method = RequestMethod.POST)
    @ResponseBody
    public String addrelation(int mid,int sid,String relation){
        if (mid==0||sid==0||relation==null){
            return "属性不能为空";
        }
        Relation relation1=new Relation(mid,sid,relation);
        relationService.insetRelation(relation1);
        return "关系添加成功！";
    }

    @RequestMapping(value = "findrelation",method = RequestMethod.POST)
    @ResponseBody
    public String findrelation(int mid,int sid){
        Relation relation=relationService.findById(mid,sid);
        if (relation==null) {
            return "两者没有关系";
        }
        Person person1=personService.findByPerId(mid);
        Person person2=personService.findByPerId(sid);
        return person1.getName()+"和"+person2.getName()+"是"+relation.getRelation()+"关系";
    }
}
