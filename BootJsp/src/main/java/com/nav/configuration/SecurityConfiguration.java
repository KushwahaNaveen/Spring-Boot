package com.nav.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationProvider authProvider;
	
   	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http

				.authorizeRequests()
				.antMatchers("/admin/**", "/su/**","/login","/resources").permitAll()
				.antMatchers("/next/*")
				.hasAnyRole("ADMIN", "SADMIN", "CUSTOMERCARE", "OPERATION", "MARKETING")
				.anyRequest().authenticated()
				.and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/next")
				.failureHandler(customAuthenticationFailureHandler()).usernameParameter("username")
				.passwordParameter("password").and().logout().logoutUrl("logoutuser").and().exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler()).and().csrf()
				.ignoringAntMatchers("/admin/**", "/open", "/open/**", "/agent/**").and().sessionManagement()
				.maximumSessions(1).maxSessionsPreventsLogin(false).expiredUrl("/login?error")
				.sessionRegistry(sessionRegistry());
		
		
        
	}

	
	@Bean
	public SessionRegistry sessionRegistry() {
		SessionRegistry sessionRegistry = new SessionRegistryImpl();
		return sessionRegistry;
	}

	@Bean
	public AuthenticationFailureHandler customAuthenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	@Bean
	public SessionListener httpSessionListener() {
		return new SessionListener();
	}
	
    @Override

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}