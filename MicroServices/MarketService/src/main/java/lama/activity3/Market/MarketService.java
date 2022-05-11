package lama.activity3.Market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketService {
    /*List<Offer> offers;

    @Autowired
    CardService cardService;

    @Autowired
    UserService userService;

    @Autowired
    OfferRepository offerRepository;

    public void SellCard(User user, Card card, int price, int quantity) {
        Offer offer = new Offer(user, card, price, quantity);
        offers.add(offer);
        user.giveMoney(offer.getPrice() * offer.getQuantity());
        offerRepository.save(offer);
    }

    public void BuyCard(User user, Offer offer) {

        if (user.getMoney() < offer.getPrice() * offer.getQuantity()) return;

        for (int i = 0; i < offer.getQuantity(); i++)
            user.getCardList().add(offer.getCard());

        user.takeMoney(offer.getPrice() * offer.getQuantity());
        offer.getUser().giveMoney(offer.getPrice() * offer.getQuantity());
        offerRepository.deleteById(offer.getId());
    }*/
}
