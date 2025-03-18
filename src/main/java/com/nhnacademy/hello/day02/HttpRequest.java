package com.nhnacademy.hello.day02;

import com.nhnacademy.hello.day02.filter.AdminPageFilter;
import com.nhnacademy.hello.day02.filter.FilterChain;
import com.nhnacademy.hello.day02.filter.MyPageFilter;

public class HttpRequest {
    private final FilterChain filterChain = new FilterChain();

    public HttpRequest(){
        initFilter();
    }

    public void doRequest(Request request){
        filterChain.doFilter(request);
    }

    private void initFilter(){
        filterChain.addFilter(new MyPageFilter());
        filterChain.addFilter(new AdminPageFilter());
    }

}
