/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.configuration;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author smwangi
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
       return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    
    
    @Override
    protected void registerDispatcherServlet(ServletContext servletContext) {

        super.registerDispatcherServlet(servletContext);
    }
    
    @Override
    protected Filter[] getServletFilters() {
        Filter[] singleton = {new CORSFilter()};
        return singleton;
    }
 
    @Override
    protected String getServletName() {
        return "crmServlet";
    }
    
}
