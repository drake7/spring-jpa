package com.example.springboot3demo.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {

    @GetMapping("/")
    public String getWorld(){
        return "Hello worlds 123346123135";
    }

    public String getTest(){

        int p = 121-1;
                return "";
    }

}
