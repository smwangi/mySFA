/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.services.impl;

import com.samwan.mysfa.dao.SystemMenuDao;
import com.samwan.mysfa.model.SystemMenus;
import com.samwan.mysfa.services.SystemMenuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author smwangi
 */
@Service
public class SystemMenuServiceImpl implements SystemMenuService{
    
    @Autowired
    SystemMenuDao _systemMenuDao;
    
    @Override
    public List<SystemMenus> fetchAll(Boolean isActive) {
        return _systemMenuDao.fetchAll(isActive);
    }

    @Override
    public SystemMenus fetchOne(Long id) {
        return _systemMenuDao.fetchOne(id);
    }

    @Override
    public SystemMenus save(SystemMenus entity) {
        return _systemMenuDao.save(entity);
    }

    @Override
    public SystemMenus update(SystemMenus entity) {
        return _systemMenuDao.update(entity);
    }

    @Override
    public SystemMenus saveorupdate(SystemMenus entity) {
        return _systemMenuDao.saveorupdate(entity);
    }
    
}
