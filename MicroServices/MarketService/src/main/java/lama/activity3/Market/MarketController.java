package lama.activity3.Market;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketController {

    @GetMapping("/")
    public String Index() {
        return "You are on the Market microservice";
    }
}
