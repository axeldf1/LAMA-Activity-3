package lama.activity3.Card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Card GetCard(Long id) {
        return cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException(id));
    }

    public List<Card> GetCards() {
        return (List<Card>) cardRepository.findAll();
    }

    public List<Card> GetRandomCards(int amount) {
        List<Card> cards = new ArrayList<>();
        List<Card> cardsList;

        for (int i = 0; i < amount; i++) {
            long cardNumber = cardRepository.count();
            cardsList = cardRepository.findAll();
            int random = new Random().nextInt((int) cardNumber);
            cards.add(cardsList.get(random));
        }

        return cards;
    }
}