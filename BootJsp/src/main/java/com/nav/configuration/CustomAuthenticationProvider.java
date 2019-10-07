package com.nav.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
 
    @Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
  
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
         System.err.println(name);
        if (name.contentEquals("A")) {
  
            // use the credentials
           
        	List<GrantedAuthority> authorities = new ArrayList<>();

            
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new UsernamePasswordAuthenticationToken(
              name, password, authorities);
        } else {
            return null;
        }
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
