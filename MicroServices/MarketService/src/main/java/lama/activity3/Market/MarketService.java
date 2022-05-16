package lama.activity3.Market;

import lama.activity3.CardDTO.Card;
import lama.activity3.Market.Model.Offer;
import lama.activity3.Market.repositories.CardRepository;
import lama.activity3.Market.repositories.MarketRepository;
import lama.activity3.Market.repositories.PlayerRepository;
import lama.activity3.PlayerDTO.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {
    List<Offer> offers;
    @Autowired
    MarketRepository marketRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    PlayerRepository playerRepository;

    public void SellCard(PlayerDTO player, Card card, int price, int quantity) {
        Offer offer = new Offer(player, card, price, quantity);
        offers.add(offer);
        player.giveMoney(offer.getPrice() * offer.getQuantity());
        marketRepository.save(offer);
    }

    public void BuyCard(User user, Offer offer) {

        if (user.getMoney() < offer.getPrice() * offer.getQuantity()) return;

        for (int i = 0; i < offer.getQuantity(); i++)
            user.getCardList().add(offer.getCard());

        user.takeMoney(offer.getPrice() * offer.getQuantity());
        offer.getUser().giveMoney(offer.getPrice() * offer.getQuantity());
        marketRepository.deleteById(offer.getId());
    }
}
