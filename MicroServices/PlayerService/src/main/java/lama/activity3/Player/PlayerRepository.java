package lama.activity3.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT u.id FROM Player u WHERE u.surname = ?1")
    Long findIdByName(String name);
}
