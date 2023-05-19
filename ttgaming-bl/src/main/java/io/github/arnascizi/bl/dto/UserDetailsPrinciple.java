package io.github.arnascizi.bl.dto;

import io.github.arnascizi.model.TtgUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public Long getId() {
        return ttgUser.getId();
    }

    public String getEmail() {
        return ttgUser.getEmail();
    }

    public LocalDateTime getCreatedAt() {
        return ttgUser.getCreatedAt();
    }

    public LocalDateTime getUpdatedAt() {
        return ttgUser.getUpdatedAt();
    }

    public List<GameDto> getUserCollection() {
        return ttgUser.getUserCollection().stream()
                .map(GameDto::of)
                .collect(Collectors.toList());
    }

    public List<GameDto> getUserWishlist() {
        return ttgUser.getUserWishlist().stream()
                .map(GameDto::of)
                .collect(Collectors.toList());
    }

}
