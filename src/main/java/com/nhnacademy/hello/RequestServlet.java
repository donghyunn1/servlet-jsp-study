package com.nhnacademy.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;

public class RequestServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(RequestServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        try(PrintWriter out = resp.getWriter()) {
            out.println("locale=" +req.getLocale());
            out.println("parameter name=" +req.getParameter("userId"));
            out.println("content type=" + req.getContentType());
            out.println("content length=" + req.getContentLength());
            out.println("method="+req.getMethod());
            out.println("servlet path=" + req.getServletPath());
            out.println("request uri=" + req.getRequestURI());
            out.println("request url=" + req.getRequestURL());
            out.println("User-Agent header=" + req.getHeader("User-Agent"));
        } catch (Exception e) {
            log.error("/req: {}", e.getMessage(),e);
        }
    }
}
