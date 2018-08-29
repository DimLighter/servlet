package com.hhg.jerry.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by lining on 2018/7/13.
 */
public class ServletHead extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
//        resp.setHeader("content-type", "text/html;charset=UTF-8");
        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()){
            String name = headers.nextElement();
            String value = req.getHeader(name);
            pw.write(name+":::"+value);
            pw.write("<br/>");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
