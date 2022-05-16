package lama.activity3.Market;

import lama.activity3.CardDTO.Card;
import lama.activity3.Market.Exceptions.OfferNotFoundException;
import lama.activity3.Market.Model.Offer;
import lama.activity3.Market.repositories.MarketRepository;
import lama.activity3.PlayerDTO.PlayerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarketController {
    private final MarketRepository marketRepository;

    public MarketController(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @GetMapping("/offers")
    List<Offer> all() {
        return marketRepository.findAll();
    }

    @PostMapping("/offers")
    void newOffer(PlayerDTO player, Card card, int price, int quantity) {
        marketRepository.save(new Offer(player, card, price, quantity));
    }

    @GetMapping("/offers/{id}")
    Offer one(@PathVariable Long id) {
        return marketRepository.findById(id)
                .orElseThrow(() -> new OfferNotFoundException(id));
    }

    @PutMapping("/offers/{id}")
    Offer replaceUser(@RequestBody Offer newOffer, @PathVariable Long id) {
        return marketRepository.findById(id)
                .map(offer -> {
                    offer.setCard(newOffer.getCard());
                    offer.setPrice(newOffer.getPrice());
                    offer.setQuantity(newOffer.getQuantity());
                    return marketRepository.save(offer);
                })
                .orElseGet(() -> {
                    newOffer.setId(id);
                    return marketRepository.save(newOffer);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        marketRepository.deleteById(id);
    }
}