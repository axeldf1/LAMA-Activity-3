package lama.activity3.Authentication.repository;

import lama.activity3.Authentication.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthUser, String> {
}
