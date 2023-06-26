package Main.Repository;

import Main.Model.Users;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Implementação da interface JpaRepository para a entidade Users.
 *
 * @author - GuiBatalhoti
 * @author - Gabriel Nozawa
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, UUID>{

    /**
     * Método que retorna um usuário pelo seu username.
     * @param username
     * @return usuário
     */
    @Query("SELECT u FROM Users u WHERE u.username = ?1")
    Users findByUsername(String username);

}
