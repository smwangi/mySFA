/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.dao;

import com.samwan.my_sfa.model.CrmAccounttypes;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author smwangi
 */
//@Component
@Repository("AccountTypeDao")
//@Transactional
public class AccountTypeDaoImpl extends AbstractBaseDao<CrmAccounttypes,Long> implements AccountTypeDao{

    
}
