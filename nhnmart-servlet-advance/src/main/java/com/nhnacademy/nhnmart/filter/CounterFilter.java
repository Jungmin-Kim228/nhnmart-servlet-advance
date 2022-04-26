//package com.nhnacademy.nhnmart.filter;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//
//@WebFilter(filterName = "counterFilter", urlPatterns = {"/foods", "/cart"})
//public class CounterFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
//                         FilterChain filterChain) throws IOException, ServletException {
//
//        int count = (int) servletRequest.getAttribute("count");
//
//        filterChain.doFilter(servletRequest, servletResponse);
//
//        servletRequest.getServletContext().setAttribute("count", ++count);
//    }
//}
