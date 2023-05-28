package io.github.arnascizi.api.helper;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Endpoint {
    public static final String API = "/api";
    public static final String GAMES = "/games";
    public static final String ID = "{id}";
    public static final String REVIEWS = "/reviews";
    public static final String NEW = "/new";
    public static final String SEARCH = "/search";
    public static final String TOP_GAMES = "/top-games";

//    Endpoints:
    public static final String TTGAMES = API + GAMES;
    public static final String GAME_REVIEWS = ID + REVIEWS;
}
