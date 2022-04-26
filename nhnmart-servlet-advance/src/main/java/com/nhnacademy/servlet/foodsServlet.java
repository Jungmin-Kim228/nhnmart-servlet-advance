package com.nhnacademy.servlet;

import com.nhnacademy.domain.Food;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class foodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        try (PrintWriter out = resp.getWriter()) {
            ArrayList<Food> foods = (ArrayList<Food>) getServletContext().getAttribute("foodStand");

            for (Food f : foods) {
                out.println("["+f.getName()+"]");
                out.println("- price: "+f.getPrice());
                out.println("- amount: "+f.getAmount());
                out.println();
            }
            out.println("Please move to /basket.html");
        }
    }
}
