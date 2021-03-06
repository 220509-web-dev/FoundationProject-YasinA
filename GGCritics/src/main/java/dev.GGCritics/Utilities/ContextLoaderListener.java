package dev.GGCritics.Utilities;

import Filters.CorsFilter;
import Service.AuthService;
import Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.GGCritics.Daos.UserDaoPostgres;
import servlets.AuthServlet;
import servlets.RegServlet;
import servlets.UserServlet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.LocalDateTime;
import java.util.EnumSet;

public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[LOG] - The servlet context was initialized at " + LocalDateTime.now());

        ObjectMapper mapper = new ObjectMapper();
        UserDaoPostgres userDao = new UserDaoPostgres();
//        CorsFilter corsFilter = new CorsFilter();
        AuthService AuthService = new AuthService(userDao);
        UserService UserService = new UserService(userDao);
        UserServlet userServlet = new UserServlet(mapper, userDao, UserService);
        AuthServlet authServlet = new AuthServlet(mapper, AuthService);
        RegServlet regServlet = new RegServlet(mapper, AuthService);

        ServletContext context = sce.getServletContext();
//        context.addFilter("CorsFilter", corsFilter)
//                .addMappingForUrlPatterns(EnumSet.of(DispatcherType.), true, "/*");
        context.addServlet("UserServlet", userServlet).addMapping("/user/*");
        context.addServlet("AuthServlet", authServlet).addMapping("/auth");
        context.addServlet("RegServlet", regServlet).addMapping("/reg");
    }

    @Override public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[LOG] - The servlet context was destroyed at " + LocalDateTime.now());
    }
}
