package com.hhg.jerry.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by lining on 2018/7/13.
 */
public class Servlet1 extends HttpServlet{

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        Enumeration<String> e = servletConfig.getInitParameterNames();
        while (e.hasMoreElements()){
            String key = e.nextElement();
            System.out.println(key + ": " + servletConfig.getInitParameter(key));
        }
        System.out.println("Servlet1 initializing ..............");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type", "text/html;charset=UTF-8");
//        OutputStream outputStream = resp.getOutputStream();
//        outputStream.write("你好".getBytes("UTF-8"));
        PrintWriter pw = resp.getWriter();
        getServletContext().setAttribute("msg","ok");
        pw.write(getServletConfig().getServletContext().getInitParameter("url").toString());
        pw.write("<br/>");
        pw.write("requestURI:" + req.getRequestURI());
        pw.write("<br/>");
        pw.write("real path："+getServletContext().getRealPath("/image/1.jpg"));
        pw.write("<br/>");
        pw.write("request.contextPath:"+req.getContextPath());

        pw.write("<br/>");
        pw.write("你好");
        System.out.println("request coming...............");
//        resp.setHeader("Location",req.getContextPath()+"/redirect");
//        resp.setStatus(HttpServletResponse.SC_FOUND);
//        resp.sendRedirect("/servlet/redirect");
//        req.getRequestDispatcher("/forward").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
