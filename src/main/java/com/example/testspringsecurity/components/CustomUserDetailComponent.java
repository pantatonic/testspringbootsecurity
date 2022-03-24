package com.example.testspringsecurity.components;




import com.example.testspringsecurity.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;


public class CustomUserDetailComponent implements UserDetails {

    private final User user;

    public CustomUserDetailComponent(User user) {
        super();
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; //false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; //false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; //false;
    }

    @Override
    public boolean isEnabled() {
        return true; //false;
    }

}
