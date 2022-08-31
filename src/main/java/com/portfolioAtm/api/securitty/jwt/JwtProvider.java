/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.securitty.jwt;

import com.portfolioAtm.api.securitty.entity.UsuarioPrincipal;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


/**
 *
 * @author Administrador
 */
@Component
public class JwtProvider {
    
       private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
       @Value("${jwt.secret}")
       private String secret;
       @Value("${jwt.expiration}")
       private int expiration;
       
       public String generateToken(Authentication auth){
           UsuarioPrincipal userPrin = (UsuarioPrincipal)auth.getPrincipal();
           
           return Jwts.builder().setSubject(userPrin.getUsername())
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                   .signWith(SignatureAlgorithm.HS512, secret)
                   .compact();   
       }
       
       public String GetNombreUsuarioFromToken(String token) {
           return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
       }
       
       public boolean validateToken(String token){
           try {
               Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
               return true;
           } catch(MalformedJwtException e){
               logger.error("Token mal Formado");
           }catch(UnsupportedJwtException e){
               logger.error("Token no soportado");
           }catch(ExpiredJwtException e){
               logger.error("Token expirado");
           }catch(IllegalArgumentException e){
               logger.error("Token mal Formado");
           }catch(SignatureException e){
               logger.error("fail en la firma");
           }
           return false;

           
           
           
           
           
       }
       
}
