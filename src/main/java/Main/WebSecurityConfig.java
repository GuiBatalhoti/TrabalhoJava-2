package Main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests((requests) -> requests
                            .requestMatchers("/", "/registration", "/registration/", "/error", "/login", "/index", "/registrationSuccess").permitAll()
                            .anyRequest().authenticated()
                    )
                    .formLogin((form) -> form
                            .loginPage("/login")
                            .permitAll()
                    )
                    .logout((logout) -> logout.permitAll());
            return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
            UserDetails user =
                     User.withDefaultPasswordEncoder()
                            .username("username")
                            .password("passwd")
                            .roles("USER")
                            .build();

            return new InMemoryUserDetailsManager(user);
    }
}
