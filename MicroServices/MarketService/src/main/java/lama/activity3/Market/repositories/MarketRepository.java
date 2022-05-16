package lama.activity3.Market.repositories;

import lama.activity3.Market.Model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<Offer, Long> {
}
