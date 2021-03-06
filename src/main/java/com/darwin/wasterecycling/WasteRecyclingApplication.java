package com.darwin.wasterecycling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;



@EnableOpenApi
@SpringBootApplication
public class WasteRecyclingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WasteRecyclingApplication.class, args);
    }

}
