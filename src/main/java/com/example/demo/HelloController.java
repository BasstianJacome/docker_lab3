package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class HelloController {


    @GetMapping("/")
    public String Hello(){



        String name = "Vinicio";
        LocalTime currentTimer = LocalTime.now();
        System.out.println("Vinicio");

        if(currentTimer.isBefore(LocalTime.NOON)){

            return ("Good morning, "+name+" Welcome to COMP367");
        } else{
            return ("Good afternoon, "+name+" Welcome to COMP367");
        }

    }
}
