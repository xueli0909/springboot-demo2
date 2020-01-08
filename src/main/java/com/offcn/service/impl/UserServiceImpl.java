package com.offcn.service.impl;

import com.offcn.dao.UserDao;
import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    /**
     * 添加
     * @param user
     */
    @Override
    public void add(User user) {
        dao.save(user);
    }

    /**
     * 修改刷新
     * @param user
     */
    @Override
    public void update(User user) {
        dao.saveAndFlush(user);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    /**
     * 根据id查找对象
     * @param id
     */
    @Override
    public User findOne(Long id) {
        Optional<User> optional = dao.findById(id);
        //isPresent方法判断查询的值是否为空
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
