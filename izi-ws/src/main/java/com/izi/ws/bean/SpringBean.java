package com.izi.ws.bean;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringBean {

    @Autowired
    private ServletContext servletContext;

    @PostConstruct
    public void showIt() {
        System.out.println(servletContext.getContextPath());
    }
}