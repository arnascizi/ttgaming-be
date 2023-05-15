package io.github.arnascizi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Immutable
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PUBLISHER")
public class Publisher {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTIOn")
    private String description;

    @Column(name = "WEBSITE_URL")
    private String websiteUrl;
}
