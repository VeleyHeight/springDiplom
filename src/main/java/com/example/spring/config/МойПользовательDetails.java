package com.example.spring.config;

import com.example.spring.model.Пользователь;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class МойПользовательDetails implements UserDetails {
    private Пользователь пользователь;


    public МойПользовательDetails(Пользователь пользователь){
        this.пользователь = пользователь;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(пользователь.getНазваниеРоли());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return пользователь.getПароль();
    }

    @Override
    public String getUsername() {
        return пользователь.getЛогин();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
