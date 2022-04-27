package com.nhnacademy.nhnmart.servlet;

import com.nhnacademy.nhnmart.domain.Food;
import com.nhnacademy.nhnmart.domain.FoodStand;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "foodsServlet", urlPatterns = "/foods")
public class FoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        try (PrintWriter out = resp.getWriter()) {
            FoodStand foodStand = (FoodStand) getServletContext().getAttribute("foodStand");

            resp.setContentType("text/html");
            printFoodStand(out, foodStand);
            printBaksetForm(out, foodStand);
        }
    }

    private void printFoodStand(PrintWriter out, FoodStand foods) {
        out.println("<h1>FoodStand</h1>");
        out.println("<ol>");
        for (Food f : foods.getFoods()) {
            out.println("<li>"+f.getName()+"</li>");
            out.println("<ul>");
            out.println("<li>"+f.getPrice()+"won</li>");
            out.println("<li>"+f.getAmount()+"</li>");
            out.println("</ul>");
        }
        out.println("</ol>");
    }


    private void printBaksetForm(PrintWriter out, FoodStand foods) {
        out.println("<hr>");
        out.println("<h1>Pick Foods You Want</h1>");
        out.println("<form method=\"post\" action=\"/cart\">");
        for (Food f : foods.getFoods()) {
            out.println("<input type=\"number\" name=\"food\"/> "+f.getName());
            out.println("<br><br>");
        }
        out.println("<input type=\"submit\"/>");
        out.println("</form>");
    }
}
