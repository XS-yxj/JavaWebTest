//package com.web.servletInitializer;
//
//import com.servlet.UserService;
//import org.springframework.web.WebApplicationInitializer;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration.Dynamic;
//
///**
// * Created by Apple on 2017/4/25.
// */
//public class SignInServletInit implements WebApplicationInitializer{
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//
//        Dynamic signInServlet = servletContext.addServlet("signInServlet", UserService.class);
//
//        signInServlet.addMapping("/servlet/UserService");
//
//
//    }
//}
