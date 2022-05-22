package lama.activity3.Market;

import lama.activity3.Market.Exceptions.OfferNotFoundException;
import lama.activity3.Market.Model.Offer;
import lama.activity3.Market.repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {
    private final MarketRepository marketRepository;
    @Autowired
    private MarketService marketService;

    public MarketController(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @GetMapping("")
    List<Offer> all() {
        return marketRepository.findAll();
    }

    @PostMapping("")
    void newOffer(@RequestBody Offer offer) {
        marketService.CreateOffer(offer);
    }

    @GetMapping("/{id}")
    Offer one(@PathVariable Long id) {
        return marketRepository.findById(id)
                .orElseThrow(() -> new OfferNotFoundException(id));
    }

    @PutMapping("/buy/{offerId}")
    void buyOffer(@PathVariable Long offerId, @RequestParam int playerId) {
        marketService.BuyOffer(playerId, offerId);
    }

//    TODO : verif quantity and remove cards in player
    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) { marketService.CancelOffer(id); }
}