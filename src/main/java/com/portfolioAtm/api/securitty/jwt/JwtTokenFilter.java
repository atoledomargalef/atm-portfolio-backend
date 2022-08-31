/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.securitty.jwt;

import com.portfolioAtm.api.securitty.service.UserDetailsServiceImpl;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Administrador
 */
public class JwtTokenFilter extends OncePerRequestFilter{

      private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
      
      @Autowired
      JwtProvider jwtProv;
      
      @Autowired              
        UserDetailsServiceImpl userDetailService;
      
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token =getToken(req);
            if (token != null && jwtProv.validateToken(token)){
                String nombreUsuario = jwtProv.GetNombreUsuarioFromToken(token);
                UserDetails userDetails = userDetailService.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }catch(Exception e){
            logger.error("fail en el metodo doFilter" + e.getMessage());
        }
        filterChain.doFilter(req, res);
    }
    
    private String getToken(HttpServletRequest req){
        String header = req.getHeader("Autorization");
        if(header != null && header.startsWith("Bearer"))
            return header.replace("Beaber ", "");
        return null;
    }
}
