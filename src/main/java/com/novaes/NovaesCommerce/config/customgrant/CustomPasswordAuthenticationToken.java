/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.novaes.NovaesCommerce.config.customgrant;

import io.micrometer.common.lang.Nullable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AuthorizationGrantAuthenticationToken;

/**
 *
 * @author blnov
 */
public class CustomPasswordAuthenticationToken extends OAuth2AuthorizationGrantAuthenticationToken {
    private static final long serialVersionUID = 1L;
	
	private final String username;
	private final String password;
	private final Set<String> scopes;
	
	public CustomPasswordAuthenticationToken(Authentication clientPrincipal,
			@Nullable Set<String> scopes, @Nullable Map<String, Object> additionalParameters) {
		
		super(new AuthorizationGrantType("password"), clientPrincipal, additionalParameters);
		
		this.username = (String) additionalParameters.get("username");
		this.password = (String) additionalParameters.get("password");
		this.scopes = Collections.unmodifiableSet(
				scopes != null ? new HashSet<>(scopes) : Collections.emptySet());
	}

	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}

	public Set<String> getScopes() {
		return this.scopes;
	}
}
