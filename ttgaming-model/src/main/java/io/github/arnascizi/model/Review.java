package io.github.arnascizi.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "REVIEW")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private TtgUser ttgUser;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "GAME_ID")
    private Game game;

    @Column(name = "RATING")
    private Integer rating;

    @Column(name = "COMMENT", length = 4000)
    private String comment;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
}
