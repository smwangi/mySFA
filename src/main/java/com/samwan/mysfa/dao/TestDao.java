/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.dao;

import com.samwan.mysfa.model.AccountTypes;

/**
 *
 * @author smwangi
 */
public interface TestDao {
   AccountTypes findById(long id); 
}
