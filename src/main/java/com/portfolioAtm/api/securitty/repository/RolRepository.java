/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioAtm.api.securitty.repository;

import com.portfolioAtm.api.securitty.entity.Rol;
import com.portfolioAtm.api.securitty.entity.Usuario;
import com.portfolioAtm.api.securitty.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Administrador
 */
public interface RolRepository extends JpaRepository<Rol, Integer >{
    
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
    
}
