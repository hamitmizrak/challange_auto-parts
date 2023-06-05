package com.ape.security.service;

import com.ape.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{

    private static final long serialVersionUID = 1L;

    private String email ; // user email ile login olacağı için ekledik

    private String password;


    // roller Granted türünde olmalı
    private Collection<? extends GrantedAuthority> authorities;

    // user --> UserDetails dönüşümünü yapacak build() metodu
    public static UserDetailsImpl build(User user) {
        List<SimpleGrantedAuthority> authorities =   user.getRoles().
                stream().
                map(role->new SimpleGrantedAuthority(role.getRoleName().name())).
                collect(Collectors.toList());

        return new UserDetailsImpl(user.getEmail(), user.getPassword(), authorities);
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
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