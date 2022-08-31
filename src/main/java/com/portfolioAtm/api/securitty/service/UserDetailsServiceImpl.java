/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.securitty.service;

import com.portfolioAtm.api.securitty.entity.Usuario;
import com.portfolioAtm.api.securitty.entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UsuarioService userServ;
    
    
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = userServ.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);  
    }
    
}
