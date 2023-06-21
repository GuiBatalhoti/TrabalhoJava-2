package Main.Repository;

import Main.Model.Usuario;
import java.util.UUID;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{
    Usuario findByUsername(String username);

}
