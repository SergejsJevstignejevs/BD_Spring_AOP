package com.sj.utils;

import org.springframework.stereotype.Component;

@Component
public class SimpleLogging {

    public void printLog(String message, int number){
        System.out.println(
            "Your message: " + message +
            " Your number: " + number);
    }

}
