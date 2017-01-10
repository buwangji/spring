package com.laowang.dao.impl;

import com.laowang.dao.UserDao;
import com.laowang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void save(User user) {
        String sql = "insert into user(name,tel) values(?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getTel());
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ? , tel = ? WHERE id = ?";
        jdbcTemplate.update(sql,user.getName(),user.getTel(),user.getId());
    }

    @Override
    public User findById(Integer id) {
        String sql = "select * from user where id =?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setTel(resultSet.getString("tel"));
                return user;
            }
        },id);
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public Long count() {
        String sql = "select count(*) from user";
        return jdbcTemplate.queryForObject(sql,new SingleColumnRowMapper<Long>());
    }
}
