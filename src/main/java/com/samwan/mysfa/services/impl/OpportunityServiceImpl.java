/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.services.impl;

import com.samwan.mysfa.dao.OpportunityDao;
import com.samwan.mysfa.model.Opportunities;
import com.samwan.mysfa.services.OpportunityService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author smwangi
 */
@Service
public class OpportunityServiceImpl implements OpportunityService{
    
    @Autowired
    OpportunityDao _opportunityDao;

    @Override
    public List<Opportunities> fetchAll(Boolean isActive) {
        return _opportunityDao.fetchAll(isActive);
    }

    @Override
    public Opportunities fetchOne(Long id) {
       return _opportunityDao.fetchOne(id);
    }

    @Override
    public Opportunities save(Opportunities entity) {
        return _opportunityDao.save(entity);
    }

    @Override
    public Opportunities update(Opportunities entity) {
        return _opportunityDao.update(entity);
    }

    @Override
    public Opportunities saveorupdate(Opportunities entity) {
        return _opportunityDao.saveorupdate(entity);
    }
    
}
