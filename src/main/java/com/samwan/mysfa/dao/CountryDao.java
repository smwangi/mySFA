/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.dao;

import com.samwan.mysfa.model.Countries;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author smwangi
 */
@Component
@Repository
public interface CountryDao extends BaseDao<Countries,Long>{
    
}
