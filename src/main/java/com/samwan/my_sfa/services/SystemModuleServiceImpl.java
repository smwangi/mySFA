/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.services;

import com.samwan.my_sfa.dao.SystemModuleDao;
import com.samwan.my_sfa.model.CrmSystemModules;
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
    public List<CrmSystemModules> fetchAll(Boolean isActive) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CrmSystemModules fetchOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CrmSystemModules save(CrmSystemModules entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CrmSystemModules update(CrmSystemModules entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CrmSystemModules saveorupdate(CrmSystemModules entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
