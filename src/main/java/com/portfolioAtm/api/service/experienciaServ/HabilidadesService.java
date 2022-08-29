/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.service.experienciaServ;

import com.portfolioAtm.api.model.Habilidades;
import com.portfolioAtm.api.repository.HabilidadesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class HabilidadesService implements IHabilidadesService {
     @Autowired
    public HabilidadesRepository habsRepo;

 @Override
    public List<Habilidades> verHabilidades() {
         return habsRepo.findAll();
    }

    @Override
    public void crearHabilidades(Habilidades habs) {
        habsRepo.save(habs);
    }

    @Override
    public void borrarHabilidades(Long id) {
       habsRepo.deleteById(id);
    }

    @Override
    public Habilidades buscarHabilidades(Long id) {
        return (Habilidades) habsRepo.findById(id).orElse(null) ;
    }

    
}
