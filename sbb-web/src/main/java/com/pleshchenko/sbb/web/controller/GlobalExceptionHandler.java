package com.pleshchenko.sbb.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created by РОМАН on 29.05.2017.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    static final Logger logger = LogManager.getLogger(TrainController.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView handleGlobalException(Exception e) {

        logger.error(e.getMessage());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("exception");

        return modelAndView;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle(Exception ex) {
        return "404";
    }

}
