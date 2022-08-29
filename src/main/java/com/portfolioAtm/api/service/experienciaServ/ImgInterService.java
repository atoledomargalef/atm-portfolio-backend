/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioAtm.api.service.experienciaServ;




import com.portfolioAtm.api.model.Imagen;
import java.util.List;

public interface ImgInterService {
    
    public List<Imagen> verImg();
    
    public void crearImg (Imagen img);
    
    public void borrarImg (Long id);
    
    public Imagen buscarImg (Long id);
    
}
