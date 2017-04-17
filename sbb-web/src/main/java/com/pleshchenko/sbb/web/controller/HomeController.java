package com.pleshchenko.sbb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by РОМАН on 05.04.2017.
 */

@Controller
@RequestMapping("/rrrrrrrrrrrrrr")
public class HomeController {


    @RequestMapping("/rrrrrrrrrrrrrr")
    public String goHome(ModelMap model){

        return "home";
    }

}

