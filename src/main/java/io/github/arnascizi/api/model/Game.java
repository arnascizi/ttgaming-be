package io.github.arnascizi.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@Builder
@Table(name = "GAME")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NAME")
    private String gameName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MIN_PLAYERS")
    private Integer minPlayers;

    @Column(name = "MAX_PLAYERS")
    private Integer maxPlayers;

    @Column(name = "MIN_AGE")
    private Integer minAge;

    @Column(name = "DURATION")
    private String duration;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "RELEASE_YEAR")
    private Integer releaseYear;

    @Column(name = "RATING")
    private Double rating;

    @OneToMany(mappedBy = "baseGameId", fetch = FetchType.LAZY)
    private List<Expansion> expansions = new ArrayList<>();

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "GAME_DESIGNERS", joinColumns = @JoinColumn(name = "GAME_ID"), inverseJoinColumns = @JoinColumn(name = "DESIGNER_ID"))
    private List<Designer> gameDesigners = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "GAME_MECHANICS", joinColumns = @JoinColumn(name = "GAME_ID"), inverseJoinColumns = @JoinColumn(name = "MECHANIC_ID"))
    private List<Mechanic> gameMechanics = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "GAME_CATEGORIES", joinColumns = @JoinColumn(name = "GAME_ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
    private List<Category> gameCategories = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "GAME_PUBLISHERS", joinColumns = @JoinColumn(name = "GAME_ID"), inverseJoinColumns = @JoinColumn(name = "PUBLISHER_ID"))
    private List<Publisher> gamePublishers = new ArrayList<>();
}
