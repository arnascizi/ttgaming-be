package io.github.arnascizi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BOARD_GAME")
public class BoardGame {

    @Id
    @Column(name = "ID")
    private Long id;
}
