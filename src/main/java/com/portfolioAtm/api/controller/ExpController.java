/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.controller;

import com.portfolioAtm.api.model.Experiencia;
import com.portfolioAtm.api.service.experienciaServ.IExperienciaService;
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




@CrossOrigin
@RestController
public class ExpController {
    
    
     @Autowired
        private IExperienciaService expServ;

        @PostMapping ("/new/experiencia")
        public String agregarExp( @RequestBody Experiencia exp) {
               expServ.crearExp(exp);
               
        return "La experiencia Fue creada Correctamente";
        } 
        
        @GetMapping ("/ver/experiencias")
        public List<Experiencia> verExp() {
            return expServ.verExp();
        }    
        
        @DeleteMapping ("/delete/experiencia/{id}")
        public void borrarExp (@PathVariable Long id) {
             
            expServ.borrarExp(id);
        }
        @PutMapping ("/editar/experiencia/{id}")
    public Experiencia editExp(@PathVariable Long id,
                                @RequestParam ("titulo") String nuevoTitulo,
                                @RequestParam ("fecha_inicio") String nuevoFecha_i,
                                @RequestParam ("fecha_final") String nuevoFecha_f,
                                @RequestParam ("descrip_tareas") String nuevaDescrip,
                                @RequestParam ("logo_empresa") String nuevoLogo,
                                @RequestParam ("refe") String nuevoRefe,
                                @RequestParam ("persona_id") int persId){
        
        Experiencia exp = expServ.buscarExp(id);
        
        exp.setTitulo(nuevoTitulo);
        exp.setFecha_inicio(nuevoFecha_i);
        exp.setFecha_final(nuevoFecha_f);
        exp.setDescrip_tareas(nuevaDescrip);
        exp.setLogo_empresa(nuevoLogo);
        exp.setRefe(nuevoRefe);
        exp.setPersona_id(persId);
        
        
        expServ.crearExp(exp);
        
        return exp;
        
        
    }
    
}
