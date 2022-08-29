/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.controller;

import com.portfolioAtm.api.model.Formacion;
import com.portfolioAtm.api.service.experienciaServ.IFormacionService;
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




@CrossOrigin(origins = "https://atm-portfolio.web.app", maxAge=3600) 
@RestController
public class ForController {
    
    
     @Autowired
        private IFormacionService forServ;

        @PostMapping ("/new/formacion")
        public String agregarFor( @RequestBody Formacion form) {
             forServ.crearFor(form);
               
        return "La formacion Fue agregada Correctamente";
        } 
        
        @GetMapping ("/ver/formacion")
        public List<Formacion> verFor() {
            return forServ.verFor();
        }    
        
        @DeleteMapping ("/delete/formacion/{id}")
        public void borrarFor (@PathVariable Long id) {
             
          forServ.borrarFor(id);
        }
        @PutMapping ("/editar/formacion/{id}")
    public Formacion editFor(@PathVariable Long id,
                                @RequestParam ("titulo") String nuevoTitulo,
                                @RequestParam ("fecha_inicio") String nuevoFecha_i,
                                @RequestParam ("fecha_final") String nuevoFecha_f,
                                @RequestParam ("descrip_for") String nuevaDescrip,
                                @RequestParam ("logo_inst") String nuevoLogo,
                                @RequestParam ("promedio") double nuevoRefe,
                                @RequestParam ("persona_id") int persId){
        
        Formacion form = forServ.buscarFor(id);
        
        form.setTitulo(nuevoTitulo);
        form.setFecha_inicio(nuevoFecha_i);
        form.setFecha_final(nuevoFecha_f);
        form.setDescrip_for(nuevaDescrip);
        form.setLogo_inst(nuevoLogo);
        form.setPromedio(nuevoRefe);
        form.setPersona_id(persId);
        
        
      forServ.crearFor(form);
        
        return form;
        
        
    }
    
}