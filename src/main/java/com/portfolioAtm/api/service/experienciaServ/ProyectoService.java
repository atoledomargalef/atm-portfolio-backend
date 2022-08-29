/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.service.experienciaServ;

import com.portfolioAtm.api.model.Proyecto;
import com.portfolioAtm.api.repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectosService{

    @Autowired
   public ProyectoRepository proyRepo;
    

    @Override
    public List<Proyecto> verProy() {
        
        return proyRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public void crearProy(Proyecto proy) {
         proyRepo.save(proy);
    }

    @Override
    public void borrarProy(Long id) {
        proyRepo.deleteById(id);   
    }
    
    @Override
    public Proyecto buscarProy(Long id) {
        
        return proyRepo.findById(id).orElse(null);  
    }
    
    
    
    
    
}
