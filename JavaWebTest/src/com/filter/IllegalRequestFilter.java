package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 过滤非登录状态的非法请求，强制跳转至登录界面
 */
//@WebFilter(filterName = "SignInFilter", urlPatterns = "/*"
//        ,initParams={@WebInitParam(name ="noUrlPatterns" , value = "base;res;index.jsp;signIn_failure.jsp;SignInServlet")})
//----------------------放行首页包括.js.css等,但还无法放下不等量状态下的error页面----------------------------

//@WebInitParam(name = "noUrlPatterns", value = "index.jsp;user/signIn_failure.jsp;SignInFilter")
public class IllegalRequestFilter implements Filter {

    FilterConfig filterConfig;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {



//      利用filter进行全局request编码转换
        String DefaultEncoding = filterConfig.getInitParameter("DefaultEncoding");
        if(DefaultEncoding == null) {
            DefaultEncoding = "utf-8";
        }
        req.setCharacterEncoding(DefaultEncoding);



        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        String noUrlPatterns = filterConfig.getInitParameter("noUrlPatterns");

//        放行非登录状态的合法请求
        if (noUrlPatterns != null) {
            String[] strArray = noUrlPatterns.split(";");

            for (String s: strArray) {

                if (s == null || s.equals("")) continue;       //防@WebInitParam配置错误

                if (request.getRequestURI().indexOf(s) != -1) {       //匹配url

                    chain.doFilter(req,resp);
                    return;
                }

            }
        }
        

//        放行登录状态，过滤非登录状态(重定向至首页)
        if (session.getAttribute("username") != null) {

            chain.doFilter(req, resp);
        }else {

            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }


    }

    public void init(FilterConfig config) throws ServletException {

//        加载初始化值
         filterConfig = config;

    }

}
