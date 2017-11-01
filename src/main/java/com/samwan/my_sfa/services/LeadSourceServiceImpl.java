/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.services;

import com.tl.tl_crm.dao.LeadSourceDao;
import com.samwan.my_sfa.model.CrmOpportunitysources;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author smwangi
 */
@Service
public class LeadSourceServiceImpl implements LeadSourceService {

    @Autowired
    LeadSourceDao _leadSourceDao;
    
    @Override
    public List<CrmOpportunitysources> fetchAll(Boolean isActive) {
        return _leadSourceDao.fetchAll(isActive);
    }

    @Override
    public CrmOpportunitysources fetchOne(Long id) {
        return _leadSourceDao.fetchOne(id);
    }

    @Override
    public CrmOpportunitysources save(CrmOpportunitysources entity) {
      return _leadSourceDao.save(entity);
    }

    @Override
    public CrmOpportunitysources update(CrmOpportunitysources entity) {
     return _leadSourceDao.update(entity);
    }

    @Override
    public CrmOpportunitysources saveorupdate(CrmOpportunitysources entity) {
        return _leadSourceDao.saveorupdate(entity);
    }
    
}
