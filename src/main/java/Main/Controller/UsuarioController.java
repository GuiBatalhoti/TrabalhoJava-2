package Main.Controller;

import Main.Model.Users;
import Main.Repository.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {
    @Autowired
    private UsersRepository ur;
    
    //Redireciona a requisição HTTP para esse método
    @GetMapping("/registration")
    public String formRegistration(Model model) {
        model.addAttribute("user", new Users());
        return "registration";
    }

    @GetMapping("/registrationSuccess")
    public String formRegistrationSuccess() {
        return "registrationSuccess";
    }

    @PostMapping("/registrationSuccess")
    public String formRegistration(@Valid Users user, BindingResult result, RedirectAttributes attributes) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/registration";
        }
        ur.save(user);
        attributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso!");
        return "redirect:/registrationSuccess";
    }

    @RequestMapping("/usuario")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView formUser() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @GetMapping("/usuario/{username}")
    public ModelAndView detalhesManga(@PathVariable("username") String username) {
        Users usuario = ur.findByUsername(username);
        ModelAndView mv = new ModelAndView("detalhesUsuario");
        mv.addObject("index", usuario);
        return mv;
    }
}
