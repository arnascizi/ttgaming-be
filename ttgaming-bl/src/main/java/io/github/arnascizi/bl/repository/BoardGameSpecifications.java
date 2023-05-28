package io.github.arnascizi.bl.repository;

import io.github.arnascizi.bl.dto.GameSearch;
import io.github.arnascizi.model.Game;
import io.github.arnascizi.model.Game_;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

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
