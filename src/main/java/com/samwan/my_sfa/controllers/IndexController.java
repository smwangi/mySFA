/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author smwangi
 */
@Controller
@RequestMapping
public class IndexController {
    @RequestMapping(method =  RequestMethod.GET)
    public String getIndexPage() {
        return "index";
    }
}
