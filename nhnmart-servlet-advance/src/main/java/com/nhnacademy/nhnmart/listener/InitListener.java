package com.nhnacademy.nhnmart.listener;

import com.nhnacademy.nhnmart.domain.Food;
import com.nhnacademy.nhnmart.domain.FoodStand;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
public class InitListener implements ServletContextListener {
    FoodStand foodStand = new FoodStand();
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        String[] foods = servletContext.getInitParameter("foodStand").split(",");

        setFoodStand(foods);
        servletContext.setAttribute("foodStand", foodStand);
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
