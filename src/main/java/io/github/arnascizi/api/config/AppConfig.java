package io.github.arnascizi.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({"io.github.arnascizi"})
@EntityScan("io.github.arnascizi.model")
@EnableJpaRepositories("io.github.arnascizi.bl.repository")
public class AppConfig {}
