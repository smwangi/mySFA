/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.services.impl;

import com.samwan.mysfa.dao.AccountTypeDao;
import com.samwan.mysfa.model.AccountTypes;
import com.samwan.mysfa.services.AccountTypeService;
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
    public List<AccountTypes> fetchAll(Boolean isActive) {
        return _accountTypeDao.fetchAll(isActive);
    }

    @Override
    public AccountTypes saveorupdate(AccountTypes entity) {
       return _accountTypeDao.saveorupdate(entity);
    }

    @Override
    public AccountTypes fetchOne(Long id) {
        return _accountTypeDao.fetchOne(id);
    }

    @Override
    public AccountTypes save(AccountTypes entity) {
        return _accountTypeDao.save(entity);
    }

    @Override
    public AccountTypes update(AccountTypes entity) {
        return  _accountTypeDao.update(entity);
    }
    
}
