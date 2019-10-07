package com.nav.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,HttpServletResponse response,AuthenticationException exception) 
      throws IOException, ServletException {
  
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        if(exception instanceof SessionAuthenticationException)
        {
            response.sendRedirect(request.getContextPath() + "/login?alreadyLoggedin");
        }else{
            response.sendRedirect(request.getContextPath() + "/login?error");
        }
      
    }
}