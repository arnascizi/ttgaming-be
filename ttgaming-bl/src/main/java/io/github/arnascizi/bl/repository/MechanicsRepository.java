package io.github.arnascizi.bl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.github.arnascizi.model.Mechanic;

@NoRepositoryBean
public interface MechanicsRepository extends JpaRepository<Mechanic, Long> {}
