package com.sda.spring.demo.component;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(servletRequest.getRemoteAddr());

        if(servletRequest.getRemoteAddr().equals("192.168.3.205")){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            servletResponse.getWriter().write("You shall not pass");
        }
    }

    @Override
    public void destroy() {

    }
}
