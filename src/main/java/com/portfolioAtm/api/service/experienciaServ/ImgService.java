/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.service.experienciaServ;

import com.portfolioAtm.api.model.Imagen;
import com.portfolioAtm.api.repository.ImagenRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */

@Service
public class ImgService implements ImgInterService {

    @Autowired
    
    public ImagenRepo imgRepo;
    

    @Override
    public List<Imagen> verImg() {
           return imgRepo.findAll();
    }

    @Override
    public void crearImg(Imagen img) {
        imgRepo.save(img);
    }

    @Override
    public void borrarImg(Long id) {
        imgRepo.deleteById(id);
    }

    @Override
    public Imagen buscarImg(Long id) {
        return imgRepo.findById(id).orElse(null);  
    }
    
}
