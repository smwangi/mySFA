/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.services.impl;

import com.samwan.mysfa.dao.SystemModuleDao;
import com.samwan.mysfa.model.SystemModules;
import com.samwan.mysfa.services.SystemModuleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author smwangi
 */
@Service
public class SystemModuleServiceImpl implements SystemModuleService{
    
    @Autowired
    SystemModuleDao _systemModuleDao;
    @Override
    public List<SystemModules> fetchAll(Boolean isActive) {
        return _systemModuleDao.fetchAll(isActive);
    }

    @Override
    public SystemModules fetchOne(Long id) {
        return _systemModuleDao.fetchOne(id);
    }

    @Override
    public SystemModules save(SystemModules entity) {
        return _systemModuleDao.save(entity);
    }

    @Override
    public SystemModules update(SystemModules entity) {
        return _systemModuleDao.update(entity);
    }

    @Override
    public SystemModules saveorupdate(SystemModules entity) {
        return _systemModuleDao.saveorupdate(entity);
    }
    
}
