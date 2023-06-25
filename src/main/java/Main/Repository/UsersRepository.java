package Main.Repository;

import Main.Model.Users;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<Users, UUID>{

    @Query("SELECT u FROM Users u WHERE u.username = ?1")
    Users findByUsername(String username);

}
