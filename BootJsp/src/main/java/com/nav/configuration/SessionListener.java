package com.nav.configuration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.context.support.SecurityWebApplicationContextUtils;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;

public class SessionListener implements HttpSessionListener {

	@Autowired
	SessionRegistry sessionRegistry;

	private static final Logger log = LogManager.getLogger(SessionListener.class);
	@Value("${admin_session_timeout}")
	private int ADMIN_SESSION_TIMEOUT;

	/*
	 * static {
	 * 
	 * try {
	 * 
	 * InputStream inputStream
	 * 
	 * = AESEncryption.class.getClassLoader().getResourceAsStream(
	 * "ApplicationResource.properties");
	 * 
	 * prop.load(inputStream);
	 * 
	 * } catch (Exception e) {
	 * 
	 * }
	 * 
	 * }
	 */

	ApplicationContext getContext(ServletContext servletContext) {
		return SecurityWebApplicationContextUtils.findRequiredWebApplicationContext(servletContext);
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("session created");
		log.info("SessionId ::" + event.getSession().getId());
		log.info("Session Time out value:: "+ADMIN_SESSION_TIMEOUT);
		event.getSession().setMaxInactiveInterval(ADMIN_SESSION_TIMEOUT);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		log.info("SessionId ::" + event.getSession().getId());
		System.out.println("session destroyed");
		HttpSessionDestroyedEvent e = new HttpSessionDestroyedEvent(event.getSession());
		log.debug("Publishing event: " + e);
		getContext(event.getSession().getServletContext()).publishEvent(e);
	}

}