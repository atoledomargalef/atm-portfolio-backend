/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioAtm.api.service.experienciaServ;

import com.portfolioAtm.api.model.Formacion;
import java.util.List;

public interface IFormacionService {
    
    public List<Formacion> verFor();
    
    public void crearFor (Formacion form);
    
    public void borrarFor (Long id);
    
    public Formacion buscarFor (Long id);
    
}
