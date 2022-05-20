package lama.activity3.Authentication;

import lama.activity3.Authentication.model.AuthUser;
import lama.activity3.Authentication.repository.AuthRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @Bean
    CommandLineRunner initDatabase(AuthRepository authRepository) {

        return args -> {
            authRepository.save(new AuthUser("test", "123"));
        };
    }
}