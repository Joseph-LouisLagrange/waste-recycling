package com.darwin.wasterecycling.entity;

import lombok.Data;

@Data
public class User {
    private long id;

    private String username;

    private String encryptedPassword;
}
