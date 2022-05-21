//package lama.activity3.Player;
//
//import lama.activity3.Player.Repositories.PlayerRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//class LoadDatabase {
//
//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//
//    @Autowired
//    private PlayerService playerService;
//
//    @Bean
//    CommandLineRunner initDatabase(PlayerRepository playerRepository) {
//
//        return args -> {
//            playerService.Register("axel", "boomer", "mdp");
//            playerService.Register("Louis", "cringe", "mdp");
//        };
//    }
//}