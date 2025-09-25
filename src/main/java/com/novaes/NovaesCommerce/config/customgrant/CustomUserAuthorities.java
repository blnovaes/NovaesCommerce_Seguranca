/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.novaes.NovaesCommerce.config.customgrant;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author blnov
 */
public class CustomUserAuthorities {

    private String username;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserAuthorities(String username, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
