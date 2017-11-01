/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.dao;

import com.samwan.my_sfa.model.CrmSalestages;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author smwangi
 */
@Component
@Repository
public interface SaleStageDao extends BaseDao<CrmSalestages,Long> {
    
}
