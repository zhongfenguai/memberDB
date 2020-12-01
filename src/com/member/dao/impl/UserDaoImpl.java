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
        return 0;
    }

    @Override
    public int delete(Long userId) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public List<User> queryAll() {
        return null;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public Integer queryPageTotalCount() {
        String sql="select count(1) from user";
        return Math.toIntExact((Long)queryForSingleValue(sql));
    }

    @Override
    public List<User> queryUserByPage(int begin, int pageSize) {
        String sql="select * from user limit ?,?";
        return queryForList(User.class,sql,begin,pageSize);
    }
}
