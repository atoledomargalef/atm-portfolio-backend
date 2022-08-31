/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.controller;

import com.portfolioAtm.api.model.Experiencia;
import com.portfolioAtm.api.model.Persona;
import com.portfolioAtm.api.service.experienciaServ.IExperienciaService;
import com.portfolioAtm.api.service.experienciaServ.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


 /*"https://atm-portfolio.web.app"*/
@CrossOrigin(origins = "http://localhost:4200", maxAge=3600) 
@RestController
public class PersController {
    
        @Autowired
        private IPersonaService perServ;

        @PostMapping ("/new/persona")
        public void agregarPersona( @RequestBody Persona pers) {
               perServ.crearPersona(pers);
        }  
        @GetMapping ("/ver/personas")
        @ResponseBody
        public List<Persona> verPersonas() {
            
            System.out.println("Prueba");
            System.out.println(perServ.verPersonas());
            System.out.println(perServ);
            
            return perServ.verPersonas();
        }    
        
        @DeleteMapping ("/delete/persona/{id}")
        public void borrarPersona (@PathVariable Long id) {
             
            perServ.borrarPersona(id);
        }
        @PutMapping ("/editar/persona/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("apellido") String nuevoApellido,
                                @RequestParam ("dni") String nuevoDNI,
                                @RequestParam ("fecha_nac") String nuevaFech_nac,
                                @RequestParam ("lugar_nac") String nuevoLugar_nac,
                                @RequestParam ("lugar_act") String nuevoLugar_act,
                                @RequestParam ("direccion_act") String nuevaDir_act,
                                @RequestParam ("telefono_cel") String nuevoTel_cel,
                                @RequestParam ("bio_about") String nuevaBio_about,
                                @RequestParam ("img_perfil") String nuevaImg_perfil,
                                @RequestParam ("profesion") String nuevaprofesion,
                                @RequestParam ("email") String nuevoEmail){
        
        Persona perso = perServ.buscarPersona(id);
        
        perso.setApellido(nuevoApellido);
        perso.setNombre(nuevoNombre);
        perso.setDni(nuevoDNI);
        perso.setFecha_nac(nuevaFech_nac);
        perso.setLugar_nac(nuevoLugar_nac);
        perso.setLugar_act(nuevoLugar_act);
        perso.setDireccion_act(nuevaDir_act);
        perso.setTelefono_cel(nuevoTel_cel);
        perso.setBio_about(nuevaBio_about);
        perso.setImg_perfil(nuevaImg_perfil);
        perso.setProfesion(nuevaprofesion);
        perso.setEmail(nuevoEmail);
       
        
        perServ.crearPersona(perso);
        
        return perso;
        
        
    }
        

    
}
