package com.hhg.jerry.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lining on 2018/7/13.
 */
public class ServletDefault extends HttpServlet {

    public void init() throws javax.servlet.ServletException {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        if(getServletContext().getAttribute("msg") != null){
            pw.write("404 :"+ getServletContext().getAttribute("msg").toString());
        }else{
            pw.write("404 :");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        this.doGet(req, resp);
    }
}