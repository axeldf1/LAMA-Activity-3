package lama.activity3.Market;

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

    public void SellCard(int playerId, int cardId, int price, int quantity) {
        PlayerDTO player = playerRepository.GetPlayer(playerId);
        Offer offer = new Offer(playerId, cardId, price, quantity);
        offers.add(offer);
        player.setMoney(offer.getPrice() * offer.getQuantity());
        marketRepository.save(offer);
        playerRepository.putPlayer(player);
    }

    public void BuyCard(int playerId, Offer offer) {
        PlayerDTO player = playerRepository.GetPlayer(playerId);
        if (player.getMoney() < offer.getPrice() * offer.getQuantity()) return;

        List<Long> cardList = player.getCardList();
        for (int i = 0; i < offer.getQuantity(); i++)
            Long l = new Long(offer.getCardId());
            cardList.add(l);

        user.takeMoney(offer.getPrice() * offer.getQuantity());
        offer.getUser().giveMoney(offer.getPrice() * offer.getQuantity());
        marketRepository.deleteById(offer.getId());
    }
}
