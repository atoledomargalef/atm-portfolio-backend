/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioAtm.api.service.experienciaServ;

import com.portfolioAtm.api.model.Proyecto;
import java.util.List;

public interface IProyectosService {
    
    public List<Proyecto> verProy();
    
    public void crearProy (Proyecto proy);
    
    public void borrarProy (Long id);
    
    public Proyecto buscarProy (Long id);
    
}