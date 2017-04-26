package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Apple on 2017/4/7.
 */
//@WebFilter(filterName = "DefaultEncodingFilter")
public class DefaultEncodingFilter implements Filter {

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
//        resp.setCharacterEncoding(DefaultEncoding); //依然乱码
        resp.setContentType("text/html;charset=" + DefaultEncoding);

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        filterConfig = config;
    }

}
