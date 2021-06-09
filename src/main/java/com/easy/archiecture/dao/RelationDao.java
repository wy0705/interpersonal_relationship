package com.easy.archiecture.dao;

import com.easy.archiecture.entity.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.jar.JarEntry;

@Repository
public class RelationDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Relation findById(int mid,int sid){
        final Relation relation=new Relation();
        String sql="select mid,sid,relation from person where id=?";
        jdbcTemplate.query(sql, new Object[]{mid, sid}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                relation.setMid(resultSet.getInt(1));
                relation.setSid(resultSet.getInt(2));
                relation.setRelation(resultSet.getString(3));
            }
        });
        return relation;
    }

    public int insetRelation(Relation relation){
        String sql="insert into relation(mid,sid,relation) value(?,?,?)";
        return jdbcTemplate.update(sql,relation.getMid(),relation.getSid(),relation.getRelation());
    }
}
