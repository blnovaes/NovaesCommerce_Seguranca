/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.novaes.NovaesCommerce.dto;

import com.novaes.NovaesCommerce.entities.User;

/**
 *
 * @author blnov
 */
public class ClientDTO {

    private long id;
    private String name;

    public ClientDTO() {
    }

    public ClientDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
