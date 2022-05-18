package lama.activity3.Card;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CardRepository cardRepository) {

        return args -> {
            Card card1 = new Card("carte 1", "description 1", "imageUrl 1", "family 1", "affinity 1", 0, 0, 0, 0);
            Card card2 = new Card("carte 2", "description 2", "imageUrl 2", "family 2", "affinity 2", 0, 0, 0, 0);
            Card card3 = new Card("carte 3", "description 3", "imageUrl 3", "family 3", "affinity 2", 0, 0, 0, 0);
            Card card4 = new Card("carte 4", "description 4", "imageUrl 4", "family 3", "affinity 3", 0, 0, 0, 0);
            Card card5 = new Card("carte 5", "description 5", "imageUrl 5", "family 3", "affinity 1", 0, 0, 0, 0);
            Card card6 = new Card("carte 6", "description 6", "imageUrl 6", "family 1", "affinity 2", 0, 0, 0, 0);
            log.info("Preloading " + cardRepository.save(card1));
            log.info("Preloading " + cardRepository.save(card2));
            log.info("Preloading " + cardRepository.save(card3));
            log.info("Preloading " + cardRepository.save(card4));
            log.info("Preloading " + cardRepository.save(card5));
            log.info("Preloading " + cardRepository.save(card6));
        };
    }
}