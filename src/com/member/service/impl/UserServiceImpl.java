package com.member.service.impl;

import com.member.dao.UserDao;
import com.member.dao.impl.UserDaoImpl;
import com.member.entity.User;
import com.member.service.UserService;
import com.member.utils.Page;

import java.util.List;

/**
 * 作者：chenbingfeng
 * 日期: 2020/12/1 16:52
 * 描述:
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public Page<User> queryByPage(int pageNo, int pageSize) {
        Page<User> page = new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页展示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = userDao.queryPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
//求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        //如果总记录数对每页展示的记录数不能整除 总页数要加一
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;

        }
        //设置总页码
        page.setPageTotal(pageTotal);
        int begin = (page.getPageNo() - 1) * pageSize;
        List<User> items = userDao.queryUserByPage(begin, pageSize);
//设置当前页面数据
        page.setItems(items);
        return page;
    }

    @Override
    public int delete(Long userId) {
        return userDao.delete(userId);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserNameAndPassword(user);
    }
}
