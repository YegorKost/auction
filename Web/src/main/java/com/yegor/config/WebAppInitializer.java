package com.yegor.config;

import com.yegor.service.config.BusinessLayerConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by YegorKost on 15.05.2017.
 */
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(BusinessLayerConfiguration.class, WebConfiguration.class);

//        servletContext.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        registration.addMapping("/auctions");
        registration.setLoadOnStartup(1);
    }
}
