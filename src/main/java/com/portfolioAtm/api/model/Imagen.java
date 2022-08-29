/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author Administrador
 */

@Getter @Setter
@Entity
public class Imagen {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String image;

    public Imagen() {
    }

    public Imagen(int id, String nombre, String image) {
        this.id = id;
        this.nombre = nombre;
        this.image = image;
    }
    
    
    
}

