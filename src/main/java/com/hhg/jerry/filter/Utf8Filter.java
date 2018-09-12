package com.hhg.jerry.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by lining on 2018/9/12.
 */
public class Utf8Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Utf8Filter doFilter enter");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request, response);
        System.out.println("Utf8Filter doFilter exit");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
