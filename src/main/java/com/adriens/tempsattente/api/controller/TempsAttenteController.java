/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.tempsattente.api.controller;

import com.adriens.tempsattente.api.service.TempsAttenteService;

import com.github.adriens.opt.tempsattente.sdk.Agence;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author meilie
 */

@RestController
public class TempsAttenteController {
    
    @Autowired
    private TempsAttenteService tempsAttenteService;
    
    private final Logger log = LoggerFactory.getLogger(TempsAttenteController.class);
    
    @GetMapping("/temps-attente/agences")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ArrayList<Agence> getAgences() throws Exception {
        try{
            return tempsAttenteService.getAgences();
        }
        catch(IOException ex){
            log.error("Impossible de récupérer les détails des agences");
            throw ex;
        }
    }
    
    @GetMapping("/temps-attente/agences/{communeName}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ArrayList<Agence> getAgences(@PathVariable String communeName) throws Exception {
        try{
            
            return tempsAttenteService.getAgences(StringUtils.stripAccents(communeName.toLowerCase()));
        }
        catch(Exception ex){
            log.error("Impossible de récupérer les détails des communes");
            return new ArrayList<Agence>();
            
        }
    }
    
    @GetMapping("/communes")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ArrayList<String> getCommunesNames() throws Exception {
        try{
            return tempsAttenteService.getCommunesNames();
        }
        catch(Exception ex){
            log.error("Impossible de récupérer les détails des communes");
            throw ex;
        }
    }
    
    @GetMapping("/temps-attente/agence/{idAgence}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Agence getAgence(@PathVariable String idAgence) throws Exception {
        try{
            return tempsAttenteService.getAgence(idAgence);
        }
        catch(Exception ex){
            log.error("Impossible de récupérer les détails des communes");
            throw ex;
        }
    }
    
}