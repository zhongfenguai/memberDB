package com.member.dao;

import com.member.entity.User;

import java.util.List;

/**
 * 作者：chenbingfeng
 * 日期: 2020/12/1 16:00
 * 描述:
 */
public interface UserDao {
    int insert(User user);

    int delete(Long userId);

    int update(User user);

    List<User> queryAll();

    User queryUserById(Long id);

    //查询当前表的总记录条数
    Integer queryPageTotalCount();

    User queryUserNameAndPassword(User user);


    //分页查询
    List<User> queryUserByPage(int begin, int pageSize);
}
