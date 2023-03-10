package fr.formation.inti.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebAppInitializer implements WebApplicationInitializer{
	
	public void onStartup(ServletContext servletContext) throws ServletException {
	        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
	        appContext.scan("fr.formation.inti");
	        appContext.register(ApplicationContextConfig.class);

	        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
	                new DispatcherServlet(new GenericWebApplicationContext()));
	        dispatcher.setLoadOnStartup(1);
	        dispatcher.addMapping("/");
	        
	        servletContext.addListener(new ContextLoaderListener(appContext));
	        
	    }
}
