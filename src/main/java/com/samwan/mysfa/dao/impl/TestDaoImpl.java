/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.dao.impl;

import com.samwan.mysfa.dao.TestDao;
import com.samwan.mysfa.model.AccountTypes;
import org.springframework.stereotype.Repository;

/**
 *
 * @author smwangi
 */
@Repository("testDao")
public class TestDaoImpl implements TestDao {

    @Override
    public AccountTypes findById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
