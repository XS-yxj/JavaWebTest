package com.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Apple on 2017/3/29.
 */
public class filterTest implements Filter{

//    初始化方法，可以读取web.xml
   @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       System.out.println("--------init--filterTest----------");
    }
//    核心方法，完成过滤器的实际操作
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       System.out.println("--------start---filterTest---------");
       filterChain.doFilter(servletRequest,servletResponse);
       System.out.println("--------end----filterTest--------");
   }
//    较少使用，释放过滤器占用资源
    @Override
    public void destroy() {
     System.out.println("--------destroy---filterTest---------");
    }
}
