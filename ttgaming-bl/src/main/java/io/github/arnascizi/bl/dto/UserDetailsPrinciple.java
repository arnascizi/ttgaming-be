package io.github.arnascizi.bl.dto;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.github.arnascizi.model.TtgUser;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDetailsPrinciple implements UserDetails {

    protected final TtgUser ttgUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return ttgUser.getPassword();
    }

    @Override
    public String getUsername() {
        return ttgUser.getUsername();
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
