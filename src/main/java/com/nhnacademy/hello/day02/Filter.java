package com.nhnacademy.hello.day02;

public interface Filter {
    void doFilter(Request request, FilterChain filterChain);
}
