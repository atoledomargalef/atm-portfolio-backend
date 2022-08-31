/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.securitty.controller;

import com.portfolioAtm.api.dto.Mensaje;
import com.portfolioAtm.api.securitty.dto.JwtDTO;
import com.portfolioAtm.api.securitty.dto.LoginUsuario;
import com.portfolioAtm.api.securitty.dto.NuevoUsuario;
import com.portfolioAtm.api.securitty.entity.Rol;
import com.portfolioAtm.api.securitty.entity.Usuario;
import com.portfolioAtm.api.securitty.enums.RolNombre;
import com.portfolioAtm.api.securitty.jwt.JwtProvider;
import com.portfolioAtm.api.securitty.service.RolService;
import com.portfolioAtm.api.securitty.service.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrador
 */

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
public class AuthController {
    
    @Autowired
    PasswordEncoder passEncoder;
    
    @Autowired
    AuthenticationManager authManager;
    
    @Autowired
    UsuarioService usuarioService;

        
    @Autowired
    RolService rolService;
    
        
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping ("/new")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos o email invalido"),HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("ese nombre no existe"),HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("ese email ya existe"),HttpStatus.BAD_REQUEST);
        Usuario usuario =
                new Usuario(nuevoUsuario.getNombre(),nuevoUsuario.getNombreUsuario(),nuevoUsuario.getEmail(),
                passEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("usuario Guardado"), HttpStatus.CREATED);
    }
          @PostMapping ("/login")     
   public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos o email invalido"),HttpStatus.BAD_REQUEST);
        Authentication auth = 
                authManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getNombreUsuario(),loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = jwtProvider.generateToken(auth);
        UserDetails userDetails = (UserDetails)auth.getPrincipal();
        JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
        
       
       
       
   }
    
    
}
