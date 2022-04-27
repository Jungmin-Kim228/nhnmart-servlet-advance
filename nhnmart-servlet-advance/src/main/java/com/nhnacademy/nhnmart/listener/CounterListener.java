package com.nhnacademy.nhnmart.listener;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
public class CounterListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        String counterFileName =
            "/WEB-INF/classes/" + servletContext.getInitParameter("counterFileName");

        Integer counter = null;
        try (DataInputStream dis = new DataInputStream(
            servletContext.getResourceAsStream(counterFileName))) {
            counter = dis.readInt();
        } catch (IOException e) {
            log.error("", e);
        }

        int count = Optional.ofNullable(counter).orElse(0);

        servletContext.setAttribute("counter", count);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        int counter = (int) servletContext.getAttribute("counter");

        String counterFileName =
            "/WEB-INF/classes/" + servletContext.getInitParameter("counterFileName");

        try (FileOutputStream fos = new FileOutputStream(
            new File(servletContext.getResource(counterFileName).toURI()));
             DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeInt(counter);
        } catch (URISyntaxException | IOException ex) {
            log.error("", ex);
        }
    }

}
