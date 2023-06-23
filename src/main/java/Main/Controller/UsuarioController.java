package Main.Controller;

import Main.Model.Users;
import Main.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository ur;
    
    //Redireciona a requisição HTTP para esse método
    @RequestMapping("/registration") 
    public String formCadastroUsuario() {
        return "registration";
    }
    
//    //Redireciona a requisição HTTP para esse método
//    @GetMapping("/cadastrarUsuario") 
//    public String cadastroUsuario() {
//        return "formUsuario";
//    }

    @PostMapping("/registration")
    public String formCadastroUsuario(@Valid Users usuario,
            BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute(
                    "mensagem", "Usuario invalido!");
            return "redirect:/registration";
        }
        ur.save(usuario);
        return "redirect:/usuario/"+usuario.getUserName();
    }
    
    @RequestMapping("/usuario")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView formUser() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
    
    @RequestMapping("/usuario/{username}")
    public ModelAndView detalhesManga(@PathVariable("username") String username) {
        Users usuario = ur.findByUsername(username);
        ModelAndView mv = new ModelAndView("detalhesUsuario");
        mv.addObject("index", usuario);
        return mv;
    }
}
