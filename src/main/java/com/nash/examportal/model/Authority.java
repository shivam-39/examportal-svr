package com.nash.examportal.model;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class Authority implements GrantedAuthority {

    private String authority;

    public void setAuthority(String authority){
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
