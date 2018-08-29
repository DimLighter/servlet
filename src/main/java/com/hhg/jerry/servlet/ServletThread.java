package com.hhg.jerry.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lining on 2018/7/13.
 */
public class ServletThread extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Begin:" + Thread.currentThread().getName());
        PrintWriter pw = resp.getWriter();
        try {
            synchronized (this){
                System.out.println("Thread count:" + Thread.activeCount());
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pw.write("Hello:" + Thread.currentThread().getName());
        System.out.println("Finished:" + Thread.currentThread().getName());
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
