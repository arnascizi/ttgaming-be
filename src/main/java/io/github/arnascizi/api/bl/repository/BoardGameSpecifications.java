package io.github.arnascizi.api.bl.repository;

import org.springframework.data.jpa.domain.Specification;

import io.github.arnascizi.api.bl.dto.GameSearch;
import io.github.arnascizi.api.model.Game;
import io.github.arnascizi.api.model.Game_;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BoardGameSpecifications {

    public static Specification<Game> buildSpecifications(GameSearch search) {
        Specification<Game> specification = Specification.where(null);
        if (search.getSearchQuery() != null) {
            specification.and((root, query, cb) -> cb.like(root.get(Game_.gameName), search.getSearchQuery()));
        }

        return specification;
    }
}
