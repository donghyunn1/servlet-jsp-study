package com.nhnacademy.hello.day01;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.logging.Logger;

public class CounterServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(CounterServlet.class.getName());

    private long counter;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        counter = Optional.ofNullable(config.getInitParameter("counter"))
                .map(Long::parseLong)
                .orElse(0l);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter++;

        try(PrintWriter writer = resp.getWriter()) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<meta charset='utf-8'>");
            writer.println("</head>");
            writer.println("<body>");
            writer.printf("<h1>%d</h1>\n",counter);
            writer.println("</body>");
            writer.println("</html>");
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }
}
