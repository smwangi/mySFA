/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.controllers;

import com.samwan.mysfa.model.VisitModes;
import com.samwan.mysfa.services.VisitModeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author smwangi
 */
@RestController
@RequestMapping("/visit-mode")
public class VisitModeController extends BaseController {
    
    @Autowired
    VisitModeService visitModeService;
    
    public String listViewModes(ModelMap map){
        List<VisitModes> visitModes = visitModeService.fetchAll(new Boolean("true"));
        //map.addAttribute(attributeName, visitModes)
        return "allVisitModes";
    }
    
}
