package com.nhnacademy.hello.day01;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class BeautifyServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(BeautifyServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String html = req.getParameter("html");
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");

        try(PrintWriter out = resp.getWriter()) {
            out.println(Jsoup.parse(html));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
