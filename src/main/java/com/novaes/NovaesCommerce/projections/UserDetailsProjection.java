/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.novaes.NovaesCommerce.projections;

/**
 *
 * @author blnov
 */
public interface UserDetailsProjection {
    
	String getUsername();
	String getPassword();
	Long getRoleId();
	String getAuthority();
}
