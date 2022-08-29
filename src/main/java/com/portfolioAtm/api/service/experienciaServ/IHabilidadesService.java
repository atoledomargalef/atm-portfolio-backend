/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioAtm.api.service.experienciaServ;

import com.portfolioAtm.api.model.Habilidades;
import java.util.List;


public interface IHabilidadesService {

       public List<Habilidades> verHabilidades();
    
    public void crearHabilidades (Habilidades habs);
    
    public void borrarHabilidades (Long id);
    
    public Habilidades buscarHabilidades (Long id);
    
}
