/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.service.experienciaServ;

import com.portfolioAtm.api.model.Formacion;
import com.portfolioAtm.api.repository.FormacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormacionService implements IFormacionService{

    @Autowired
   public FormacionRepository forRepo;
    
    
    @Override
    public List<Formacion> verFor() {
        return forRepo.findAll();
    }

    @Override
    public void crearFor(Formacion form) {
        forRepo.save(form);
    }

    @Override
    public void borrarFor(Long id) {
        forRepo.deleteById(id);    
    }

    @Override
    public Formacion buscarFor(Long id) {        
        return (Formacion) forRepo.findById(id).orElse(null) ;

    }
    
    
    
    
    
}
