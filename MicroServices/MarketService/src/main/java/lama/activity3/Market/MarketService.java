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
    @Autowired
    MarketRepository marketRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    PlayerRepository playerRepository;

    public void CreateOffer(Offer offer) {
        PlayerDTO player = playerRepository.GetPlayer(offer.getPlayerId());

        List<Long> playerCardList = player.getCardList();
        int cardLeft = offer.getQuantity();
        Long l = (long) offer.getCardId();

        for (int i = 0; i < cardLeft; i++) {

            if (playerCardList.remove(l))
                cardLeft--;
        }

        if (cardLeft != 0) return;

        player.setCardList(playerCardList);

        marketRepository.save(offer);
        playerRepository.putPlayer(player);
    }

    public void BuyOffer(int playerId, Long offerId) {
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

    public void CancelOffer(Long offerId) {
        Offer offer = marketRepository.getById(offerId);
        PlayerDTO player = playerRepository.GetPlayer(offer.getPlayerId());

        List<Long> playerCardList = player.getCardList();

        for (int i = 0; i < offer.getQuantity(); i++)
            playerCardList.add((long) offer.getCardId());

        playerRepository.putPlayer(player);
        marketRepository.deleteById(offerId);
    }
}
