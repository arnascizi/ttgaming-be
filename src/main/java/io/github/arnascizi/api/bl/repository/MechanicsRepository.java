package io.github.arnascizi.api.bl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.github.arnascizi.api.model.Mechanic;

@NoRepositoryBean
public interface MechanicsRepository extends JpaRepository<Mechanic, Long> {}
