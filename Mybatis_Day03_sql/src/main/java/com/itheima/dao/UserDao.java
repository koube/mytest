package com.itheima.dao;

import com.itheima.domain.QueryVO;
import com.itheima.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findUser(User user);
    List<User> findByIDS(QueryVO vo);
}
