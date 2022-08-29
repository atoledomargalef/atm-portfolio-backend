/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioAtm.api.service.experienciaServ;

import com.portfolioAtm.api.model.Habilidad;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IHabilidadService {

        
     public List<Habilidad> verHabilidad();
    
    public void crearHabilidad (Habilidad hab);
    
    public void borrarHabilidad (Long id);
    
    public Habilidad buscarHabilidad (Long id);
}
