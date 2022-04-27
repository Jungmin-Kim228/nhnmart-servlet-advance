package com.nhnacademy.nhnmart.servlet;

import com.nhnacademy.nhnmart.domain.Food;
import com.nhnacademy.nhnmart.domain.FoodStand;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "initServlet", urlPatterns = "/init")
public class InitServlet extends HttpServlet {
    private final FoodStand foodStand = new FoodStand();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        String[] foods = getServletContext().getInitParameter("foodStand").split(",");

        setFoodStand(foods);

        getServletContext().setAttribute("foodStand", foodStand);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        resp.sendRedirect("/foods");
    }

    private void setFoodStand(String[] foods) {
        for (int i = 0; i < foods.length; i += 3) {
            this.foodStand.add(
                new Food(foods[i],
                    Integer.parseInt(foods[i + 1]),
                    Integer.parseInt(foods[i + 2])));
        }
    }
}
