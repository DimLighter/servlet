package com.hhg.jerry.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by lining on 2018/7/13.
 */
public class ServletSession extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        session.setAttribute("name","ted");
        String sessionId = session.getId();
        if(session.isNew()){
            resp.getWriter().print("第一次，session的id是："+sessionId);
        }else{
            resp.getWriter().print("非非非，session的id是："+sessionId);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
