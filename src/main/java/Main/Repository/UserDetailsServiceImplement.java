package Main.Repository;

import Main.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;


import java.util.Collection;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

/**
 * Classe de implementação do UserDetailsService
 * @see UserDetailsService
 *
 * @author - GuiBatalhoti
 * @author - Gabriel Nozawa
 */
@Service
public class UserDetailsServiceImplement implements UserDetailsService{

    /**
     * Repositório de usuários
     * @see UsersRepository
     */
    @Autowired
    private UsersRepository usersRepository;

    /**
     * Método que carrega o usuário pelo username
     * @param username
     * @return datalhes do Usuário
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
