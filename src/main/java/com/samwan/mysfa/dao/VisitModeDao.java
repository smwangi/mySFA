/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.dao;

import com.samwan.mysfa.model.VisitModes;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author smwangi
 */
@Component
public interface VisitModeDao extends BaseDao<VisitModes,Long> {
    
}
