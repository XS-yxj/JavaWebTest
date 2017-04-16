package com.filter;


import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *    1. error过滤器,该过滤器可以捕捉错误进行记录,需要放行
 *    2. 没用设置过滤器类型dispatcher，默认request类型
 */
//@WebFilter( filterName = "ErrorFilter", urlPatterns = "/*", dispatcherTypes = {DispatcherType.ERROR})
public class ErrorFilter implements Filter{

    //    初始化方法，可以读取web.xml
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //    核心方法，完成过滤器的实际操作
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("--------检查到错误信息---------");


//        放行
        filterChain.doFilter(servletRequest, servletResponse);

    }

    //    较少使用，释放过滤器占用资源
    @Override
    public void destroy() {

    }
}
