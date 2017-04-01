package com.pleshchenko.sbb;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[0];
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
