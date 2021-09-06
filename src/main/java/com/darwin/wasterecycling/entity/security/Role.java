package com.darwin.wasterecycling.entity.security;


import lombok.Data;

import java.util.Set;

@Data
public class Role {
    private long id;

    private Set<Permission> permissions;
}
