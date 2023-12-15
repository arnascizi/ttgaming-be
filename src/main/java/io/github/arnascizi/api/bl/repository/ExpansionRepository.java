package io.github.arnascizi.api.bl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.github.arnascizi.api.model.Expansion;

@NoRepositoryBean
public interface ExpansionRepository extends JpaRepository<Expansion, Long> {}
