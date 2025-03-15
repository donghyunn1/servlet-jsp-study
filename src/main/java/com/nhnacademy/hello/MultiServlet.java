package com.nhnacademy.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class MultiServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(MultiServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] values = req.getParameterValues("class");
        try(PrintWriter out = resp.getWriter()){
            out.println(String.join(",", values));
        }catch (IOException ex){
            log.info(ex.getMessage());
        }
    }
}
