/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.services;

import com.samwan.my_sfa.dao.UserDao;
import com.samwan.my_sfa.model.CrmUsers;
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
    public List<CrmUsers> fetchAll(Boolean isActive) {
        return _userDao.fetchAll(isActive);
    }

    @Override
    public CrmUsers fetchOne(Long id) {
        return _userDao.fetchOne(id);
    }

    @Override
    public CrmUsers save(CrmUsers entity) {
        return _userDao.save(entity);
    }

    @Override
    public CrmUsers update(CrmUsers entity) {
        return _userDao.update(entity);
    }

    @Override
    public CrmUsers saveorupdate(CrmUsers entity) {
        return _userDao.saveorupdate(entity);
    }
    
}
