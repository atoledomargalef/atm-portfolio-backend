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
public class Formacion {
    
      
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String fecha_inicio;
    private String fecha_final;
    private String descrip_for;
    private String logo_inst;
    private double promedio;
    private int persona_id;

    public Formacion() {
    }

    public Formacion(Long id, String titulo, String fecha_inicio, String fecha_final, String descrip_for, String logo_inst, double promedio, int persona_id) {
        this.id = id;
        this.titulo = titulo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.descrip_for = descrip_for;
        this.logo_inst = logo_inst;
        this.promedio = promedio;
        this.persona_id = persona_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public String getDescrip_for() {
        return descrip_for;
    }

    public void setDescrip_for(String descrip_for) {
        this.descrip_for = descrip_for;
    }

    public String getLogo_inst() {
        return logo_inst;
    }

    public void setLogo_inst(String logo_inst) {
        this.logo_inst = logo_inst;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }
    
    
    
    
}
