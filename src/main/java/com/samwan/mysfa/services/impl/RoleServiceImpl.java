/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.services.impl;

import com.samwan.mysfa.dao.RoleDao;
import com.samwan.mysfa.model.Usergroups;
import com.samwan.mysfa.services.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author smwangi
 */
@Service
public class RoleServiceImpl implements RoleService{
    
    @Autowired
    RoleDao _roleDao;
    
    @Override
    public List<Usergroups> fetchAll(Boolean isActive) {
        return _roleDao.fetchAll(isActive);
    }

    @Override
    public Usergroups fetchOne(Long id) {
        return _roleDao.fetchOne(id);
    }

    @Override
    public Usergroups save(Usergroups entity) {
        return _roleDao.save(entity);
    }

    @Override
    public Usergroups update(Usergroups entity) {
        return _roleDao.update(entity);
    }

    @Override
    public Usergroups saveorupdate(Usergroups entity) {
        return _roleDao.saveorupdate(entity);
    }
    
}
