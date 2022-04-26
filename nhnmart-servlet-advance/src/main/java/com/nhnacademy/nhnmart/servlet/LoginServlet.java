package com.nhnacademy.nhnmart.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "loginServlet", urlPatterns = "/login",
initParams = {
    @WebInitParam(name = "id", value = "user1"),
    @WebInitParam(name = "pw", value = "1111")
})
public class LoginServlet extends HttpServlet {
    private String configId;
    private String configPw;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        configId = config.getInitParameter("id");
        configPw = config.getInitParameter("pw");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession(false);
        if (Objects.isNull(session)) {
            resp.sendRedirect("/loginForm.html");
        } else {
            PrintWriter out = resp.getWriter();
            out.println("Login Success");
            out.println("User: " + session.getAttribute("id"));

            out.println("<a href='/foods'>/foods</a>");
            out.println("<a href='/logout'>/logout</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        if (configId.equals(id) && configPw.equals(pw)) {
            HttpSession session = req.getSession();
            session.setAttribute("id", id);

            resp.sendRedirect("/login");
        } else {
            resp.sendRedirect("/login.html");
        }
    }
}
