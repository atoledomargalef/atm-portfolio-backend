/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.service.experienciaServ;

import com.portfolioAtm.api.model.Experiencia;
import com.portfolioAtm.api.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{

    @Autowired
   public ExperienciaRepository expRepo;
    
    
    @Override
    public List<Experiencia> verExp() {
        return expRepo.findAll();
    }

    @Override
    public void crearExp(Experiencia exp) {
        expRepo.save(exp);
    }

    @Override
    public void borrarExp(Long id) {
        expRepo.deleteById(id);    
    }

    @Override
    public Experiencia buscarExp(Long id) {
        return expRepo.findById(id).orElse(null);
    }
    
    
    
    
    
}
