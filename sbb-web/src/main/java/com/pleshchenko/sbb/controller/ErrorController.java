package com.pleshchenko.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/errors")
public class ErrorController {

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String get404(){
        System.out.println("dfdf");
        return "error";
    }
}
