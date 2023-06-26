package Main.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * RoutingController
 *
 * @author - GuiBatalhoti
 * @author - Gabriel Nozawa
 */
@Controller
public class RoutingController {

    /**
     * Rota para a página de login
     * @return String
     */
    @GetMapping(value = {"", "/", "/index", "/login"})
    public String login() {
        return "login" ;
    }

    /**
     * Rota para a página de cadastro
     * @return String
     */
    @GetMapping(value = {"/teste"})
    public String teste() {
        return "teste" ;
    }
    
    
}
