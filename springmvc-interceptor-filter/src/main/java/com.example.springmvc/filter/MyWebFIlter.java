package com.example.springmvc.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: demo
 * @date: 2021/12/10
 * @author: gaorunding1
 * @description:
 **/
@WebFilter
@Order(1)
@Component
public class MyWebFIlter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyWebFIlter..doFilter...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyWebFIlter..init...");
    }

    @Override
    public void destroy() {
        System.out.println("MyWebFIlter..destroy...");
    }
}
