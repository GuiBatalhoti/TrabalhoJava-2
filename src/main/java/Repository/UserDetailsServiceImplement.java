package Repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImplement implements UserDetailsService{
    final UsuarioRepository ur;

    public UserDetailsServiceImplement(UsuarioRepository ur){
        this.ur = ur;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return ur.findByUsername(username);
    }
    
}
