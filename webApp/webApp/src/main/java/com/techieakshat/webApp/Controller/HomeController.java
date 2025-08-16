package com.techieakshat.webApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/helo")
    public String greet(){
        return "Welcome brother!!";
    }
}
