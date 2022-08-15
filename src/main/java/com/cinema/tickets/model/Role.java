package com.cinema.tickets.model;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,Admin;

    @Override
    public String getAuthority() {
        return name();
    }
}

