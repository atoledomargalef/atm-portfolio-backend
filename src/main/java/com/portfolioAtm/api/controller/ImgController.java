/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.controller;

import com.portfolioAtm.api.model.Habilidades;
import com.portfolioAtm.api.model.Imagen;
import com.portfolioAtm.api.service.experienciaServ.IHabilidadesService;
import com.portfolioAtm.api.service.experienciaServ.ImgInterService;
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
public class ImgController {
   



   
    
     @Autowired
        private ImgInterService imgServ;

        @PostMapping ("/new/img")
        public String agregarImg( @RequestBody Imagen img) {
               imgServ.crearImg(img);
               
        return "La experiencia Fue creada Correctamente";
        } 
        
        @GetMapping ("/ver/img")
        public List<Imagen> verHabs() {
            return imgServ.verImg();
        }    
        
        @DeleteMapping ("/delete/img/{id}")
        public void borrarImg (@PathVariable Long id) {
             
            imgServ.borrarImg(id);
        }
        @PutMapping ("/editar/img/{id}")
    public Imagen editImg(@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("image") String nuevaImg
                                ){
        
        Imagen img = imgServ.buscarImg(id);
        
        img.setNombre(nuevoNombre);
        img.setImage(nuevaImg);
        
        
        imgServ.crearImg(img);
        
        return img;
        
        
    }
}