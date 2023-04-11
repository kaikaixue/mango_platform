package com.xkk.mango.admin.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 安全用户模型
 */
public class JwtUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String salt;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails(String username, String password, String salt, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getSalt() {
        return salt;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
