/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;




@Getter @Setter
@Entity
public class Habilidades {
    


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descripcion;
    private int porcentaje;
        private String habilidades;

    public Habilidades() {
    }

    public Habilidades(Long id, String descripcion, int porcentaje, String habilidades ) {
        this.id = id;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
        this.habilidades = habilidades;
    }

    
}
