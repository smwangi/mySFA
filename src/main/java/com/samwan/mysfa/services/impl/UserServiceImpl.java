/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.services.impl;

import com.samwan.mysfa.dao.UserDao;
import com.samwan.mysfa.model.Users;
import com.samwan.mysfa.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author smwangi
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    UserDao _userDao;
    
    @Override
    public List<Users> fetchAll(Boolean isActive) {
        return _userDao.fetchAll(isActive);
    }

    @Override
    public Users fetchOne(Long id) {
        return _userDao.fetchOne(id);
    }

    @Override
    public Users save(Users entity) {
        return _userDao.save(entity);
    }

    @Override
    public Users update(Users entity) {
        return _userDao.update(entity);
    }

    @Override
    public Users saveorupdate(Users entity) {
        return _userDao.saveorupdate(entity);
    }
    
}
