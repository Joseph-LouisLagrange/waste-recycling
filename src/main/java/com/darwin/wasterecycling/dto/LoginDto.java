package com.darwin.wasterecycling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class LoginDto {
    private boolean success;
    private String message;

    public static LoginDto loginSuccess(){
        return new LoginDto(true,null);
    }
    public static LoginDto loginFail(String message){
        return new LoginDto(false,message);
    }
}
