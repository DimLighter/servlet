package com.hhg.jerry.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lining on 2018/7/13.
 */
public class ServletException extends HttpServlet{

    public void init() throws javax.servlet.ServletException {
        System.out.println("Servlet1 initializing ..............");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.write("Hello");
        int i = 1;
        i = i/0;
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        this.doGet(req, resp);
    }
}
