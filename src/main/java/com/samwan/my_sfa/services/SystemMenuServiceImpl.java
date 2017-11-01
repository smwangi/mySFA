/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.services;

import com.tl.tl_crm.dao.SystemMenuDao;
import com.samwan.my_sfa.model.CrmSystemMenus;
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
    public List<CrmSystemMenus> fetchAll(Boolean isActive) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CrmSystemMenus fetchOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CrmSystemMenus save(CrmSystemMenus entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CrmSystemMenus update(CrmSystemMenus entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CrmSystemMenus saveorupdate(CrmSystemMenus entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
