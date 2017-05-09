//package com.web.interceptor;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by Apple on 2017/4/23.
// */
//public class EncodingInterceptor implements HandlerInterceptor{
//
////   请求处理前调用，返回值表示是否放行，true表示放行
////    Object表示被拦截的请求对象的目标对象(Controller)
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        request.setCharacterEncoding("utf-8");
////        bug不起作用
//        response.setContentType("text/html;charset=utf-8");
//
//        return true;
//    }
//    //    请求处理后调用(Controller->Viewer途中)
////    可以通过ModelAndView参数来改变显示的视图，或修改发往视图的方法
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//
//    }
//
//
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//
//}
