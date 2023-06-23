package Main.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutingController {
    @GetMapping("/")
    public String index(){
        return "login";
    }
    
    @GetMapping("/index")
    public String index1(){
        return "login";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
