/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioAtm.api.securitty.jwt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrador
 */

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    
    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);
    
    
    
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {
        logger.error("fail en el metodo commence()" + " -/- " + HttpServletResponse.SC_UNAUTHORIZED+ " -/- " + HttpStatus.UNAUTHORIZED.getReasonPhrase()+ " -/- " + authException.getMessage());
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, HttpStatus.UNAUTHORIZED.getReasonPhrase());
    
    }
    
}
