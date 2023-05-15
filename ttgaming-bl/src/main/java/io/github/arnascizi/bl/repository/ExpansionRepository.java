package io.github.arnascizi.bl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.github.arnascizi.model.Expansion;

@NoRepositoryBean
public interface ExpansionRepository extends JpaRepository<Expansion, Long> {}
