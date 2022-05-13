package lama.activity3.Card;

import lama.activity3.CardDTO.Card;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class CardController {

    private final CardRepository repository;

    CardController(CardRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cards")
    List<Card> all() {
        return repository.findAll();
    }

    @PostMapping("/cards")
    Card newCard(@RequestBody Card newCard) {
        return repository.save(newCard);
    }

    @GetMapping("/cards/{id}")
    Card one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CardNotFoundException(id));
    }

    @PutMapping("/cards/{id}")
    Card replaceCard(@RequestBody Card newCard, @PathVariable Long id) {

        return repository.findById(id)
                .map(card -> {
                    card.setName(newCard.getName());
                    card.setFamily(newCard.getFamily());
                    return repository.save(card);
                })
                .orElseGet(() -> {
                    newCard.setId(id);
                    return repository.save(newCard);
                });
    }

    @DeleteMapping("/cards/{id}")
    void deleteCard(@PathVariable Long id) {
        repository.deleteById(id);
    }
}