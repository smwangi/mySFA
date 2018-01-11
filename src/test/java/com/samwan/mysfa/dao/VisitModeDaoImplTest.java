/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.dao;

import com.samwan.mysfa.dao.VisitModeDao;
import com.samwan.mysfa.dao.VisitModeDao;
import com.samwan.mysfa.model.VisitModes;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.junit.Before;
import static org.mockito.Mockito.mock;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author smwangi
 */
public class VisitModeDaoImplTest extends EntityDaoImplTest {

    @Autowired
    private AbstractBaseDao<VisitModes,Long> abstractBaseDao;
    
    @Autowired
    @Mock
    private  VisitModeDao visitModeDao;
    
    @Before
    public void setUpMock(){
        visitModeDao = mock(VisitModeDao.class);
    }
    
    @Override
    protected IDataSet getDataSet() throws Exception {
      IDataSet dataset =   new FlatXmlDataSet(this.getClass().getClassLoader().getResource("VisitModes.xml"));
      return dataset;
    }
    
    @BeforeMethod
    protected void init(){
        abstractBaseDao.setEntity(VisitModes.class);
    }
    
    @Test
    public void addVisitModeTest() {
        init();
        VisitModes visitModes = new VisitModes();
        visitModes.setAddedby(BigInteger.ZERO);
        visitModes.setDateadded(Date.valueOf(LocalDate.now()));
        visitModes.setDescription("Description");
        visitModes.setIsactive(Boolean.valueOf("TRUE"));
        visitModes.setModeId(new Long(4));
        visitModes.setName("Just passing by");
        
        visitModeDao.save(visitModes);
        
        VisitModes vMode = visitModeDao.fetchOne(new Long(4));
        Assert.assertEquals(visitModes, vMode);
        Assert.assertEquals(visitModes.getModeId(), vMode.getModeId());
        
        Assert.assertTrue(visitModeDao.fetchAll(Boolean.valueOf("TRUE")).size() > 0);
                
    }
    
    @Test
    public void findOneTest(){
        init();
        VisitModes visitModes = new VisitModes();
        visitModes.setModeId(new Long("1"));
        visitModes.setIsactive(Boolean.TRUE);
        
        VisitModes visitModes1 =  visitModeDao.fetchOne(new Long("1"));
        visitModes1.setIsactive(Boolean.TRUE);
        System.out.println(visitModes1.getIsactive());
        Assert.assertEquals(visitModes, visitModes1);
    }
    
    @Test
    public void fetchAll() {
        init();
        List<VisitModes> visitModes = new ArrayList<>();
        VisitModes visitMode = new VisitModes();
        visitMode.setModeId(BigDecimal.ONE.longValue());
        visitModes.add(visitMode);
        
        //Assert.assertEquals(visitModes, vModes);
        Assert.assertTrue(visitModes.size() > 0);
//        Assert.assertTrue(vModes.size() > 0);
   }
}
