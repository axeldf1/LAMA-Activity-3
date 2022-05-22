package lama.activity3.Game;

import lama.activity3.CardDTO.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}