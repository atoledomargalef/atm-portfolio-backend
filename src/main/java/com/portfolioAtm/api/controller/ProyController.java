/*
 */
package com.portfolioAtm.api.controller;

import com.portfolioAtm.api.model.Proyecto;
import com.portfolioAtm.api.service.experienciaServ.IProyectosService;
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




@CrossOrigin(origins = "http://localhost:4200", maxAge=3600) 
@RestController
public class ProyController {
    
    
     @Autowired
        private IProyectosService proyServ;

        @PostMapping ("/new/proyecto")
        public String agregarProy( @RequestBody Proyecto proy) {
               proyServ.crearProy(proy);
               
        return "El proyecto fue creado Correctamente";
        } 
        
        @GetMapping ("/ver/proyectos")
        public List<Proyecto> verProy() {
            return proyServ.verProy();
        }    
        
        @DeleteMapping ("/delete/proyecto/{id}")
        public void borrarProy (@PathVariable Long id) {
             
            proyServ.borrarProy(id);
        }
        @PutMapping ("/editar/proyectos/{id}")
    public Proyecto editProy(@PathVariable Long id,
                                @RequestParam ("titulo") String nuevoTitulo,
                                @RequestParam ("descript_proj") String nuevoDescrip,
                                @RequestParam ("img_proyecto") String nuevoImgProy,
                                @RequestParam ("link_proj") String nuevaLink,
                                @RequestParam ("habilidades") String nuevaHabilidades,
                                @RequestParam ("persona_id") int persId){
        
        Proyecto proy = proyServ.buscarProy(id);
        
        proy.setTitulo(nuevoTitulo);
        proy.setDescrip_proj(nuevoDescrip);
        proy.setImg_proyecto(nuevoImgProy);
        proy.setLink_proj(nuevaLink);
        proy.setHabilidades(nuevaHabilidades);
        proy.setPersona_id(persId);
        
        
        proyServ.crearProy(proy);
        
        return proy;
        
        
    }
    
}
