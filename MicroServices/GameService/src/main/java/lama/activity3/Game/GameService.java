package lama.activity3.Game;

import lama.activity3.CardDTO.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    CardRepository cardRepository;

    public Long CompareCards(Long hostCardId, Long guestCardId)
    {
        Card hostCard = cardRepository.GetCard(hostCardId);
        Card guestCard = cardRepository.GetCard(guestCardId);

        return (hostCard.getHp() / guestCard.getAttack() > guestCard.getHp() / hostCard.getAttack()) ? hostCardId : guestCardId;
    }
}
