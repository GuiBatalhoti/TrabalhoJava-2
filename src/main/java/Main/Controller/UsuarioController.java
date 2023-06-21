package Main.Controller;

import Main.Model.Usuario;
import Main.Repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository ur;
    
    //Redireciona a requisição HTTP para esse método
    @RequestMapping("/cadastrarUsuario") 
    public String formCadastroUsuario() {
        return "formUsuario";
    }
    
    //Redireciona a requisição HTTP para esse método
    @GetMapping("/cadastrarUsuario") 
    public String cadastroUsuario() {
        return "formUsuario";
    }

//    @PostMapping("/cadastrarUsuario")
//    public String formCadastroUsuario(@Valid Usuario usuario,
//            BindingResult result, RedirectAttributes attributes) {
//        if (result.hasErrors()) {
//            attributes.addFlashAttribute(
//                    "mensagem", "Usuario invalido!");
//            return "redirect:/cadastrarUsuario";
//        }
//        ur.save(usuario);
//        return "redirect:/usuario";
//    }
    
    @RequestMapping("/usuario")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView formUser() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    
    @RequestMapping("/usuario/{username}")
    public ModelAndView detalhesManga(@PathVariable("username") String username) {
        Usuario usuario = ur.findByUsername(username);
        ModelAndView mv = new ModelAndView("detalhesUsuario");
        mv.addObject("usuario", usuario);
        return mv;
    }
}
