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

    public void BuyCard(int playerId, Long offerId) {
        Offer offer = marketRepository.getById(offerId);
        PlayerDTO buyer = playerRepository.GetPlayer(playerId);
        PlayerDTO seller = playerRepository.GetPlayer(offer.getPlayerId());

        if (buyer.getMoney() < offer.getPrice() * offer.getQuantity()) return;

        List<Long> cardList = buyer.getCardList();
        for (int i = 0; i < offer.getQuantity(); i++)
            cardList.add((long) offer.getCardId());


        buyer.setMoney(buyer.getMoney() - offer.getPrice() * offer.getQuantity());
        playerRepository.putPlayer(buyer);
        seller.setMoney(seller.getMoney() + offer.getPrice() * offer.getQuantity());
        playerRepository.putPlayer(seller);

        marketRepository.deleteById(offer.getId());
    }
}
