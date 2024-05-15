package com.sys.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @Author SfO
 * @Version 1.0
 */
@WebFilter(filterName = "loginfilter",urlPatterns = {"/*"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        //登录界面不拦截
        if(requestURI.indexOf("login")!=-1 || requestURI.indexOf("Login")!=-1 || request.getContextPath().equals(requestURI)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //判断是否登录
        HttpSession session = request.getSession();
        String loginFalg = (String)session.getAttribute("loginFlag");
        if(loginFalg == null){
            request.getRequestDispatcher("/myjsp/logerror.jsp").forward(request,response);
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
