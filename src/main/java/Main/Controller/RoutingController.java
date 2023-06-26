package Main.Controller;

import Main.Model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutingController {
    @GetMapping(value = {"", "/", "/index", "/login"})
    public String login() {
        return "login" ;
    }
    
    @GetMapping(value = {"/teste"})
    public String teste() {
        return "teste" ;
    }
    
    
}
