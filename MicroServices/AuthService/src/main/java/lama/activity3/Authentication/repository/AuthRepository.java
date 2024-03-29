package lama.activity3.Authentication.repository;

import lama.activity3.Authentication.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<AuthUser, Long> {
    @Query(value = "SELECT u FROM AuthUser u where u.userName = ?1 and u.password = ?2 ")
    Optional<AuthUser> login(String username, String password);
//    Optional<AuthUser> findByToken(String token);
    @Query("select a from AuthUser a where a.userName = ?1")
    Optional<AuthUser> findAuthUserByUser_name(String username);
}
