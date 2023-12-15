package io.github.arnascizi.api.bl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties("ttgaming")
public class TtGamingProperties {
    // TODO remove!

    private String alphabet;
    private String salt;
    private int minimumLength;
}
