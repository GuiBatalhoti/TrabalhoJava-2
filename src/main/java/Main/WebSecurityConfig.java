package Main;

import Main.Repository.UserDetailsServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

/**
 * Classe de configuração do Spring Security
 *
 * @author - GuiBatalhoti
 * @author - Gabriel Nozawa
 */
@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

    /**
     * Método que configura o Spring Security para utilizar os detalhes de usuário implementados
     * @return UserDetailsServiceImplement
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImplement();
    }

    /**
     * Método que configura o Spring Security para utilizar o BCryptPasswordEncoder
     * @return BCryptPasswordEncoder
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Método que configura o Spring Security para utilizar o DaoAuthenticationProvider
     * @return DaoAuthenticationProvider
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    /**
     * Método que configura o Spring Security para utilizar o DaoAuthenticationProvider
     * @param http
     * @see HttpSecurity
     * @return SecurityFilterChain
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.csrf().disable().
                    authorizeHttpRequests((requests) -> requests
                            .requestMatchers("/", "/registration", "/registration/", "/error", "/login", "/index", "/registrationSuccess").permitAll()
                            .requestMatchers("/resources/**").permitAll()
                            .anyRequest().authenticated()
                    ).formLogin((form) -> form
                            .loginPage("/login")
                            .defaultSuccessUrl("/lista", true)
                            .permitAll()
                    );
            return http.build();
    }
}
