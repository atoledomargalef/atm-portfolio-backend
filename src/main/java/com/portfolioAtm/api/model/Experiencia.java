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
public class Experiencia { 
    
      
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titulo;
    private String fecha_inicio;
    private String fecha_final;
    private String descrip_tareas;
    private String logo_empresa;
    private String refe;
    private int persona_id;

    public Experiencia() {
    }
    
    public Experiencia(int id, String titulo, String fecha_inicio, String fecha_final, String descrip_tareas, String logo_empresa, String refe, int persona_id) {
        this.id = id;
        this.titulo = titulo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.descrip_tareas = descrip_tareas;
        this.logo_empresa = logo_empresa;
        this.refe = refe;
        this.persona_id = persona_id;
    }

    
    
    
}
