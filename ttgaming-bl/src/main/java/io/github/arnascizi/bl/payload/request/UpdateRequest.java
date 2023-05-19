package io.github.arnascizi.bl.payload.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateRequest {

    private String username;
    private String email;
    private String oldPassword;
    private String newPassword;
}
