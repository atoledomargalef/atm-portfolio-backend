/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.service.experienciaServ;

import com.portfolioAtm.api.model.Habilidad;
import com.portfolioAtm.api.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class HabilidadService implements IHabilidadService{
   
    @Autowired
    public HabilidadRepository habRepo;

    @Override
    public List<Habilidad> verHabilidad() {
        return habRepo.findAll();
    }

    @Override
    public void crearHabilidad(Habilidad hab) {
        habRepo.save(hab);
    }

    @Override
    public void borrarHabilidad(Long id) {
       habRepo.deleteById(id);
    }

    @Override
    public Habilidad buscarHabilidad(Long id) {
        return (Habilidad) habRepo.findById(id).orElse(null) ;
    }
    
    
}
