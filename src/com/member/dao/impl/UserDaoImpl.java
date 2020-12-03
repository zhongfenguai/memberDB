package com.member.dao.impl;

import com.member.dao.BaseDao;
import com.member.dao.UserDao;
import com.member.entity.User;

import java.util.List;

/**
 * 作者：chenbingfeng
 * 日期: 2020/12/1 16:03
 * 描述:
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int insert(User user) {
        String sql="INSERT INTO user (username,password,image,type,status)values(?,?,?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getImage(),user.getType(),user.getStatus());
    }

    @Override
    public int delete(Long userId) {
        String sql = "delete from user where id=?";
        return update(sql, userId);
    }

    @Override
    public int update(User user) {
        String sql="update user set username=?,password=?,image=?,type=?,status=? where id=?";
        return update(sql,user.getUsername(),user.getPassword(),user.getImage(),user.getType(),user.getStatus(),user.getId());
    }

    @Override
    public List<User> queryAll() {
        String sql = "select *from user";
        return queryForList(User.class,sql);
    }

    @Override
    public User queryUserById(Long id) {
        String sql = "select *from user where id=?";
        return queryForOne(User.class,sql,id);
    }

    @Override
    public Integer queryPageTotalCount() {
        String sql="select count(1) from user";
        return Math.toIntExact((Long)queryForSingleValue(sql));
    }

    @Override
    public User queryUserNameAndPassword(User user) {
        String sql="select *from user where username=? and password =?";
        return queryForOne(User.class,sql,user.getUsername(),user.getPassword());
    }

    @Override
    public List<User> queryUserByPage(int begin, int pageSize) {
        String sql="select * from user limit ?,?";
        return queryForList(User.class,sql,begin,pageSize);
    }
}
