/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.services;

import com.samwan.my_sfa.dao.OpportunityDao;
import com.samwan.my_sfa.model.CrmOpportunities;
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
    public List<CrmOpportunities> fetchAll(Boolean isActive) {
        return _opportunityDao.fetchAll(isActive);
    }

    @Override
    public CrmOpportunities fetchOne(Long id) {
       return _opportunityDao.fetchOne(id);
    }

    @Override
    public CrmOpportunities save(CrmOpportunities entity) {
        return _opportunityDao.save(entity);
    }

    @Override
    public CrmOpportunities update(CrmOpportunities entity) {
        return _opportunityDao.update(entity);
    }

    @Override
    public CrmOpportunities saveorupdate(CrmOpportunities entity) {
        return _opportunityDao.saveorupdate(entity);
    }
    
}
