package lama.activity3.Room;

import lama.activity3.PlayerDTO.PlayerDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerDTO, Long> {
}
