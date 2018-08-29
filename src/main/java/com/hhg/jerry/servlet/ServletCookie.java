package com.hhg.jerry.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by lining on 2018/7/13.
 */
public class ServletCookie extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        Cookie[] cookies = req.getCookies();
        String word = "first...........";
        String sessionId = "no sessionId";
        if(cookies != null){
            for(Cookie c:cookies){
                if(c.getName().equals("lastAccessTime")){
                    word = "You accessed，last time:"+c.getValue();
                }
                if(c.getName().equals("JSESSIONID")){
                    sessionId = c.getValue();
                }
            }
        }
        resp.getWriter().write(word);
        resp.getWriter().write("<br/>");
        resp.getWriter().write(sessionId);
        Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
        resp.addCookie(cookie);
        cookie.setMaxAge(0);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
