/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.securitty.service;

import com.portfolioAtm.api.securitty.entity.Usuario;
import com.portfolioAtm.api.securitty.repository.UsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    UsuarioRepository userRepo;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return userRepo.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return userRepo.existsByNombreUsuario(nombreUsuario);
    }

        public boolean existsByEmail(String email){
        return userRepo.existsByEmail(email);
    }
        
        public void save(Usuario usuario){
            userRepo.save(usuario);
        }
    
}
