package com.nhnacademy.hello.day01;

import jakarta.servlet.ServletContext;

import java.util.Optional;

public class CounterUtils {

    private CounterUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void increaseCounter(ServletContext servletContext) {
        Long counter = Optional.ofNullable((Long) servletContext.getAttribute("counter")).orElse(0l);
        counter++;
        servletContext.setAttribute("counter", counter);
    }
}
