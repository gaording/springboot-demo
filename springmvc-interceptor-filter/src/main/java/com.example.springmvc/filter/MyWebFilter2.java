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
@Order(2)
@Component
public class MyWebFilter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyWebFIlter2..doFilter...");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyWebFIlter2..init...");
    }

    @Override
    public void destroy() {
        System.out.println("MyWebFIlter2..destroy...");
    }
}
