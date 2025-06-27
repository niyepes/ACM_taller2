package com.acm.taller2.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.net.URI;

@Configuration
@ComponentScan
public class Appconfig {
    @Autowired
    private ApplicationArguments args;
    @PostConstruct
    public void openHomePage(){
        try{

            String url = "doc/swagger-ui/index.html";
            if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
                Desktop.getDesktop().browse(new URI(url));
            }
        }catch(Exception e){

        }

    }
}



