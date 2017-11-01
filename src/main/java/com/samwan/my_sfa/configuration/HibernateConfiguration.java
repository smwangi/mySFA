/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.configuration;


import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author smwangi
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({"com.tl.tl_crm.configuration"})
@PropertySource(value = "file:${user.home}/wildfly/crm_configs/nightly_application.properties")
public class HibernateConfiguration {
    
    @Autowired
    public Environment environment;
    
    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        System.out.println("Scanning model folder");
        sessionFactoryBean.setPackagesToScan(new String[]{"com.tl.tl_crm.model","com.tl.tl_crm.dao"});
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("DB_DRIVER_CLASS"));//("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("DB_URL"));
        dataSource.setUsername(environment.getRequiredProperty("DB_USERNAME"));
        dataSource.setPassword(environment.getProperty("DB_PASSWORD"));
        return dataSource;
    }
    
    
    private Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.classloading.use_current_tccl_as_parent", false);
        return properties;
    } 
    
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
