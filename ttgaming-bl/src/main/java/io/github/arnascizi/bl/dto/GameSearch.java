package io.github.arnascizi.bl.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameSearch {

    private String searchQuery;
    private int activePage;
    private int pageSize;
}
