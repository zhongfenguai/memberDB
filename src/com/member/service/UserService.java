package com.member.service;

import com.member.entity.User;
import com.member.utils.Page;

/**
 * 作者：chenbingfeng
 * 日期: 2020/12/1 16:49
 * 描述:
 */
public interface UserService {
    Page<User> queryByPage(int page,int pageSize);
    int delete(Long userId);
    User login(User user);


}
