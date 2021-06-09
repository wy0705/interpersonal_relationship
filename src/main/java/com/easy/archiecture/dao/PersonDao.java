package com.easy.archiecture.dao;

import com.easy.archiecture.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PersonDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Person findByPerId(int id){
        final Person person=new Person();
        String sql="select name,age,password from person where id=?";
        jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                person.setName(resultSet.getString(1));
                person.setAge(resultSet.getInt(2));
                person.setPassword(resultSet.getString(3));
            }
        });
        return person;
    }

    public Person findByname(String name){
        final Person person=new Person();
        String sql="select name,age,password from person where name=?";
        jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                person.setName(resultSet.getString(1));
                person.setAge(resultSet.getInt(2));
                person.setPassword(resultSet.getString(3));
            }
        });
        return person;
    }

    public int insertPerson(Person person){
        String sql="insert into person(name,age,password) value(?,?,?)";
        return jdbcTemplate.update(sql,person.getName(),person.getAge(),person.getPassword());
    }

    public int updatePerson(Person person){
        String sql="update person set name=? age=? password=? where id=?";
        return jdbcTemplate.update(sql,person.getName(),person.getAge(),person.getPassword());
    }
}
