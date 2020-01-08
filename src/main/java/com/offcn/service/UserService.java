package com.offcn.service;

import com.offcn.po.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void update(User user);

    void delete(Long id);

    User findOne(Long id);

    List<User> findAll();
}
