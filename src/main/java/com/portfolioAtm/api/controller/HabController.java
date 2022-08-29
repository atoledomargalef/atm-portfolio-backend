/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.controller;

import com.portfolioAtm.api.model.Habilidad;
import com.portfolioAtm.api.service.experienciaServ.IHabilidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrador
 */

@CrossOrigin(origins = "http://localhost:4200", maxAge=3600) 
@RestController
public class HabController {
   
    
     @Autowired
        private IHabilidadService habServ;

        @PostMapping ("/new/habilidad")
        public String agregarHab( @RequestBody Habilidad hab) {
               habServ.crearHabilidad(hab);
               
        return "La experiencia Fue creada Correctamente";
        } 
        
        @GetMapping ("/ver/habilidad")
        public List<Habilidad> verHab() {
            return habServ.verHabilidad();
        }    
        
        @DeleteMapping ("/delete/habilidad/{id}")
        public void borrarHab (@PathVariable Long id) {
             
            habServ.borrarHabilidad(id);
        }
        @PutMapping ("/editar/habilidad/{id}")
    public Habilidad editHab(@PathVariable Long id,
                                @RequestParam ("key") String key,
                                @RequestParam ("value") String value
                                
                                ){
        
        Habilidad hab = habServ.buscarHabilidad(id);
        
        hab.setKey(key);
        hab.setValue(value);
        
        
        habServ.crearHabilidad(hab);
        
        return hab;
        
        
    }
    
}

