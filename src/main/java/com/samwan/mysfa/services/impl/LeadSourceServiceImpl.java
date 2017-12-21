/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.services.impl;

import com.samwan.mysfa.dao.LeadSourceDao;
import com.samwan.mysfa.model.OpportunitySources;
import com.samwan.mysfa.services.LeadSourceService;
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
    public List<OpportunitySources> fetchAll(Boolean isActive) {
        return _leadSourceDao.fetchAll(isActive);
    }

    @Override
    public OpportunitySources fetchOne(Long id) {
        return _leadSourceDao.fetchOne(id);
    }

    @Override
    public OpportunitySources save(OpportunitySources entity) {
      return _leadSourceDao.save(entity);
    }

    @Override
    public OpportunitySources update(OpportunitySources entity) {
     return _leadSourceDao.update(entity);
    }

    @Override
    public OpportunitySources saveorupdate(OpportunitySources entity) {
        return _leadSourceDao.saveorupdate(entity);
    }
    
}
