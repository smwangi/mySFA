/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.controllers;

import com.samwan.mysfa.model.Countries;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author smwangi
 */
@RestController
@RequestMapping("/country")
public class CountryController extends BaseController {
    
    public ResponseEntity<String> create(@RequestBody Countries crmCountry,UriComponentsBuilder uriComponentsBuilder){
        String response = "";
        
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
