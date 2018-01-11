/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.dao.impl;

import com.samwan.mysfa.dao.AbstractBaseDao;
import com.samwan.mysfa.dao.AccountTypeDao;
import com.samwan.mysfa.model.AccountTypes;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author smwangi
 */
@Component
@Repository("accountTypeDao")
public class AccountTypeDaoImpl extends AbstractBaseDao<AccountTypes,Long> implements AccountTypeDao{

}
