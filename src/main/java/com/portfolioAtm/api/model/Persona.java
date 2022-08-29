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
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String fecha_nac;
    private String lugar_nac;
    private String lugar_act;
    private String direccion_act;
    private String telefono_cel;
    private String email;
    private String bio_about;
    private String img_perfil;
    private String profesion;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String dni, String fecha_nac, String lugar_nac, String lugar_act, String direccion_act, String telefono_cel, String email, String bio_about, String img_perfil, String profesion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nac = fecha_nac;
        this.lugar_nac = lugar_nac;
        this.lugar_act = lugar_act;
        this.direccion_act = direccion_act;
        this.telefono_cel = telefono_cel;
        this.email = email;
        this.bio_about = bio_about;
        this.img_perfil = img_perfil;
        this.profesion = profesion;
    }
 
    
    
    
    
    
}
