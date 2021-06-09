package com.easy.archiecture.service;

import com.easy.archiecture.dao.RelationDao;
import com.easy.archiecture.entity.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationServiceImpl {
    @Autowired
    private RelationDao relationDao;

    public Relation findById(int mid, int sid){
        return relationDao.findById(mid,sid);
    }

    public int insetRelation(Relation relation){
        return relationDao.insetRelation(relation);
    }
}
