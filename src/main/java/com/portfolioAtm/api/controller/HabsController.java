/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.controller;

import com.portfolioAtm.api.model.Habilidad;
import com.portfolioAtm.api.model.Habilidades;
import com.portfolioAtm.api.service.experienciaServ.IHabilidadesService;
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

@CrossOrigin(origins = "https://atm-portfolio.web.app", maxAge=3600) 
@RestController
public class HabsController {
   
    
     @Autowired
        private IHabilidadesService habsServ;

        @PostMapping ("/new/habilidades")
        public String agregarHabs( @RequestBody Habilidades hab) {
               habsServ.crearHabilidades(hab);
               
        return "La experiencia Fue creada Correctamente";
        } 
        
        @GetMapping ("/ver/habilidades")
        public List<Habilidades> verHabs() {
            return habsServ.verHabilidades();
        }    
        
        @DeleteMapping ("/delete/habilidades/{id}")
        public void borrarHabs (@PathVariable Long id) {
             
            habsServ.borrarHabilidades(id);
        }
        @PutMapping ("/editar/habilidades/{id}")
    public Habilidades editHabs(@PathVariable Long id,
                                @RequestParam ("porcentaje") int nuevoPors,
                                @RequestParam ("habilidades") String nuevaHab,
                                @RequestParam ("descripcion") String nuevaDesc
                                ){
        
        Habilidades habs = habsServ.buscarHabilidades(id);
        
        habs.setPorcentaje(nuevoPors);
        habs.setDescripcion(nuevaDesc);
        habs.setHabilidades(nuevaHab);
        
        
        habsServ.crearHabilidades(habs);
        
        return habs;
        
        
    }
    
}


