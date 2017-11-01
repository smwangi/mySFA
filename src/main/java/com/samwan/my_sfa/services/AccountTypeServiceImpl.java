/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.services;

import com.tl.tl_crm.dao.AccountTypeDao;
import com.samwan.my_sfa.model.CrmAccounttypes;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author smwangi
 */
@Component
public class AccountTypeServiceImpl implements AccountTypeService {

    @Autowired
    AccountTypeDao _accountTypeDao;
            
    @Override
    public List<CrmAccounttypes> fetchAll(Boolean isActive) {
        return _accountTypeDao.fetchAll(isActive);
    }

    @Override
    public CrmAccounttypes saveorupdate(CrmAccounttypes entity) {
       return _accountTypeDao.saveorupdate(entity);
    }

    @Override
    public CrmAccounttypes fetchOne(Long id) {
        return _accountTypeDao.fetchOne(id);
    }

    @Override
    public CrmAccounttypes save(CrmAccounttypes entity) {
        return _accountTypeDao.save(entity);
    }

    @Override
    public CrmAccounttypes update(CrmAccounttypes entity) {
        return  _accountTypeDao.update(entity);
    }
    
}
