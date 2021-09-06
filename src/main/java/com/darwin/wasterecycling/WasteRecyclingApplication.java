package com.darwin.wasterecycling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

import java.util.concurrent.CompletableFuture;


@EnableOpenApi
@SpringBootApplication
public class WasteRecyclingApplication {

    public static void main(String[] args) {
        //SpringApplication.run(WasteRecyclingApplication.class, args);
        CompletableFuture<String> completableFuture=CompletableFuture
                .supplyAsync(()-> "hh")
                .whenComplete(((s, throwable) -> {
                    System.out.println(Thread.currentThread().getId());
                }));

    }

}
