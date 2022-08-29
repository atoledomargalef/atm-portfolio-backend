/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;




@Getter @Setter
@Entity
public class Proyecto {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descrip_proj;
    private String img_proyecto;
    private String link_proj;
    private String habilidades;
    private int persona_id;

    public Proyecto() {
    }

    public Proyecto(Long id, String titulo, String descrip_proj, String img_proyecto, String link_proj, String habilidades, int persona_id) {
        this.id = id;
        this.titulo = titulo;
        this.descrip_proj = descrip_proj;
        this.img_proyecto = img_proyecto;
        this.link_proj = link_proj;
        this.habilidades = habilidades;
        this.persona_id = persona_id;
    }

    
    
    
}
