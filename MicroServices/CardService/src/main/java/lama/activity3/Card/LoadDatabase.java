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
            Card card = new Card("String name", "String description", "String imageUrl", "String family", "String affinity", 0, 0, 0, 0);
            Card card2 = new Card("Axel", "String description", "String imageUrl", "String family", "String affinity", 0, 0, 0, 0);
            log.info("Preloading " + cardRepository.save(card));
            log.info("Preloading " + cardRepository.save(card2));
        };
    }
}