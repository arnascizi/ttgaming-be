package io.github.arnascizi.bl.repository;

import io.github.arnascizi.model.Game;
import io.github.arnascizi.model.Game_;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor
public class BoardGameSpecifications {

    public static Specification<Game> buildSpecifications() {
        return (((root, query, cb) -> cb.isNotNull(root.get(Game_.id))));
    }
}
