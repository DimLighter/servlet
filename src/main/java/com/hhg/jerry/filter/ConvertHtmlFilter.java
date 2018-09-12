package com.hhg.jerry.filter;

import com.hhg.jerry.request.decorator.HtmlCharConvertRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by lining on 2018/9/12.
 */
public class ConvertHtmlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("ConvertHtmlFilter enter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        HtmlCharConvertRequest htmlCharConvertRequest = new HtmlCharConvertRequest((HttpServletRequest)request);
        chain.doFilter(htmlCharConvertRequest, response);
        System.out.println("ConvertHtmlFilter exit &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }

    @Override
    public void destroy() {

    }
}
