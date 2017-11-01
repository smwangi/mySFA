/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.services;

import com.samwan.my_sfa.dao.RoleDao;
import com.samwan.my_sfa.model.CrmUsergroups;
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
    public List<CrmUsergroups> fetchAll(Boolean isActive) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CrmUsergroups fetchOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CrmUsergroups save(CrmUsergroups entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CrmUsergroups update(CrmUsergroups entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CrmUsergroups saveorupdate(CrmUsergroups entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
