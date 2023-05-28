package io.github.arnascizi.bl.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRequest {

    private String username;
    private String email;
    private String oldPassword;
    private String newPassword;
}
