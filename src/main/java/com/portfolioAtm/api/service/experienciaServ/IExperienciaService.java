/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioAtm.api.service.experienciaServ;

import com.portfolioAtm.api.model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    
    public List<Experiencia> verExp();
    
    public void crearExp (Experiencia exp);
    
    public void borrarExp (Long id);
    
    public Experiencia buscarExp (Long id);
    
}
