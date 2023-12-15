package io.github.arnascizi.api.bl.service;

import java.time.LocalDateTime;

import javax.security.auth.login.LoginException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.arnascizi.api.bl.dto.AuthBody;
import io.github.arnascizi.api.bl.dto.UserDetailsPrinciple;
import io.github.arnascizi.api.bl.payload.request.RegisterRequest;
import io.github.arnascizi.api.bl.payload.request.UpdateRequest;
import io.github.arnascizi.api.bl.repository.impl.UserRepositoryImpl;
import io.github.arnascizi.api.model.TtgUser;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepositoryImpl userRepository;

    public UserDetailsPrinciple authenticate(@NonNull AuthBody body) throws LoginException {
        TtgUser ttgUser = userRepository.getUserByUsername(body.getUsername());
        if (ttgUser == null) {
            throw new LoginException("Unable to login");
        }
        return new UserDetailsPrinciple(ttgUser);
    }

    @Override
    public UserDetailsPrinciple loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        TtgUser account = userRepository.getUserByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserDetailsPrinciple(account);
    }

    public boolean existsByEmail(@NonNull String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsByUsername(@NonNull String username) {
        return userRepository.existsByUsername(username);
    }

    public void registerUser(@NonNull RegisterRequest request) {
        TtgUser user = new TtgUser();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
    }

    public void updateUserCredentials(@NonNull UpdateRequest request) {
        TtgUser user = userRepository.getUserByUsername(request.getUsername());
        if (!StringUtils.isBlank(request.getNewPassword())) {
            user.setPassword(request.getNewPassword());
        }

        if (!StringUtils.isBlank(request.getEmail())) {
            user.setEmail(request.getEmail());
        }

        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
    }
}
