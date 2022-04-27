package com.nhnacademy.nhnmart.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter(filterName = "counterFilter", urlPatterns = {"/foods", "/cart"})
public class CounterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        int count = (int) servletRequest.getServletContext().getAttribute("counter");
        servletRequest.getServletContext().setAttribute("counter", ++count);
        log.error(String.valueOf(count));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
