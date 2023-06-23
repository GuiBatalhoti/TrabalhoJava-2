package Main.Repository;

import Main.Model.Users;
import java.util.UUID;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Users, UUID>{
    Users findByUsername(String username);

}
