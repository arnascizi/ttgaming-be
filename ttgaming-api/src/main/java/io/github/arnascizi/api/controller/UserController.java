package io.github.arnascizi.api.controller;

import io.github.arnascizi.api.utility.JwtUtils;
import io.github.arnascizi.bl.dto.UserDetailsPrinciple;
import io.github.arnascizi.bl.payload.request.LoginRequest;
import io.github.arnascizi.bl.payload.request.RegisterRequest;
import io.github.arnascizi.bl.payload.request.UpdateRequest;
import io.github.arnascizi.bl.payload.response.MessageResponse;
import io.github.arnascizi.bl.payload.response.UserInfoResponse;
import io.github.arnascizi.bl.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CommonsLog
public class UserController {

    private final AuthenticationManager authManager;
    private final UserService userService;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest request) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsPrinciple userDetails = (UserDetailsPrinciple) authentication.getPrincipal();
        ResponseCookie cookie = jwtUtils.generateJwtCookie(userDetails);
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new UserInfoResponse(
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        userDetails.getPassword(),
                        userDetails.getCreatedAt(),
                        userDetails.getUpdatedAt(),
                        userDetails.getUserCollection(),
                        userDetails.getUserWishlist()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        if (userService.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        request.setPassword(encoder.encode(request.getPassword()));
        userService.registerUser(request);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UpdateRequest request) {
        UserDetailsPrinciple principle = userService.loadUserByUsername(request.getUsername());
        if (principle == null) {
            return ResponseEntity.badRequest().body(new MessageResponse("Bad input!"));
        }

        if (!request.getNewPassword().isEmpty()) {
            if (encoder.matches(request.getOldPassword(), principle.getPassword())) {
                request.setNewPassword(encoder.encode(request.getNewPassword()));
            }
        }
        userService.updateUserCredentials(request);
        return ResponseEntity.ok().body(new MessageResponse("User updated!"));

    }
}
