package com.easy.archiecture.service;

import com.easy.archiecture.dao.PersonDao;
import com.easy.archiecture.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.DigestUtils;

@Service
public class PersonServiceImpl {
    @Autowired
    private PersonDao personDao;

    @Autowired
    private TransactionTemplate txTemplate;

    public Person findByPerId(int id){
        return personDao.findByPerId(id);
    }

    public Person findByname(String name){
        return personDao.findByname(name);
    }

    public int insertPerson(Person person){
        return personDao.insertPerson(person);
    }

    public boolean register(Person person){
        //用户重名校验
        Person person1=findByname(person.getName());
        if (person1 != null && person1.getName() != null && person1.getName().equals(person.getName())) {
            return true;
        }
        ////对用户密码进行MD5,目的是，数据库中的敏感数据，不要存储明文。
        person.setPassword(DigestUtils.md5DigestAsHex(person.getPassword().getBytes()));
        return personDao.insertPerson(person)!=0;
    }
}
