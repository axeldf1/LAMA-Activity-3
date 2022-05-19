package lama.activity3.Market;

import lama.activity3.Market.Exceptions.OfferNotFoundException;
import lama.activity3.Market.Model.Offer;
import lama.activity3.Market.repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarketController {
    @Autowired
    private MarketService marketService;
    private final MarketRepository marketRepository;

    public MarketController(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @GetMapping("/offers")
    List<Offer> all() {
        return marketRepository.findAll();
    }

    @PostMapping("/offers")
    void newOffer(@RequestBody Offer offer) {
        marketRepository.save(new Offer(offer.getPlayerId(), offer.getCardId(), offer.getPrice(), offer.getQuantity()));
    }

    @GetMapping("/offers/{id}")
    Offer one(@PathVariable Long id) {
        return marketRepository.findById(id)
                .orElseThrow(() -> new OfferNotFoundException(id));
    }

    @GetMapping("/offers/buy/{offerId}")
    void buyOffer(@PathVariable Long offerId, @RequestParam int playerId){
        marketService.BuyCard(playerId, offerId);
    }

    @PutMapping("/offers/{id}")
    Offer replaceOffer(@RequestBody Offer newOffer, @PathVariable Long id) {
        return marketRepository.findById(id)
                .map(offer -> {
                    offer.setCardId(newOffer.getCardId());
                    offer.setPrice(newOffer.getPrice());
                    offer.setQuantity(newOffer.getQuantity());
                    return marketRepository.save(offer);
                })
                .orElseGet(() -> {
                    newOffer.setId(id);
                    return marketRepository.save(newOffer);
                });
    }

    @DeleteMapping("/offers/{id}")
    void deleteUser(@PathVariable Long id) {
        marketRepository.deleteById(id);
    }
}