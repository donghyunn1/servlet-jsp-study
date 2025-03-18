package com.nhnacademy.hello.day02.filter;

import com.nhnacademy.hello.day02.Request;

public interface Filter {
    void doFilter(Request request, FilterChain filterChain);
}
