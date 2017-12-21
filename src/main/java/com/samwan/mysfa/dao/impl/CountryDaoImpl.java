/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.dao.impl;

import com.samwan.mysfa.dao.AbstractBaseDao;
import com.samwan.mysfa.dao.CountryDao;
import com.samwan.mysfa.model.Countries;
import org.springframework.stereotype.Component;

/**
 *
 * @author smwangi
 */
@Component
public class CountryDaoImpl extends AbstractBaseDao<Countries, Long>  implements CountryDao{
    
}
