package com.darwin.wasterecycling.entity.security;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private long id;

    private Set<Role> roles;
}
