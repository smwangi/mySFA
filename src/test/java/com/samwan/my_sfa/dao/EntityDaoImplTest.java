/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.dao;


import com.samwan.my_sfa.configuration.HibernateTestConfiguration;
import javax.sql.DataSource;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author smwangi
 */
//@ContextConfiguration(classes = {HibernateTestConfiguration.class})
@ContextConfiguration(classes = {HibernateTestConfiguration.class})
public abstract class EntityDaoImplTest extends AbstractTransactionalTestNGSpringContextTests {
    
    @Autowired
    DataSource _dataSource;
    
    @BeforeMethod
    public void setup() throws Exception{
        IDatabaseConnection dbConn = new DatabaseDataSourceConnection(_dataSource);
        DatabaseOperation.CLEAN_INSERT.execute(dbConn, getDataSet());
    }
    
    protected abstract IDataSet getDataSet() throws Exception;
}
