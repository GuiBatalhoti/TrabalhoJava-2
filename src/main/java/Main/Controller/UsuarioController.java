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

/**
 * Classe responsável por controlar as requisições HTTP relacionadas ao usuário
 *
 * @author - GuiBatalhoti
 * @author - Gabriel Nozawa
 */
@Controller
public class UsuarioController {

    /**
     * Injeção de dependência da classe UsersRepository
     */
    @Autowired
    private UsersRepository ur;

    /**
     * Método responsável por retornar a página de login
     * @return página de login
     */
    @GetMapping("/registration")
    public String formRegistration(Model model) {
        model.addAttribute("user", new Users());
        return "registration";
    }

    /**
     * Método responsável por retornar a página cadastro bem sucedido
     * @return registro de usuário bem sucedido
     */
    @GetMapping("/registrationSuccess")
    public String formRegistrationSuccess() {
        return "registrationSuccess";
    }

    /**
     * Método responsável por validar o registro de um usuário
     * @param user usuário a ser registrado
     * @param result resultado da validação
     * @param attributes atributos da requisição
     * @see Users
     * @see BindingResult
     * @see RedirectAttributes
     */
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

    /**
     * Método responsável por retornar a página de usuario
     * @return página de usuario
     * @see ModelAndView
     */
    @RequestMapping(value = {"/usuario", "/usuario/"})
    @PreAuthorize("isAuthenticated()")
    public ModelAndView formUser() {
        ModelAndView mv = new ModelAndView("detalhesUsuario");
        return mv;
    }

    /**
     * Método responsável por retornar a página de usuario
     * @return página de usuario
     * @see ModelAndView
     */
    @GetMapping("/usuario/{username}")
    public ModelAndView detalhesManga(@PathVariable("username") String username) {
        Users usuario = ur.findByUsername(username);
        ModelAndView mv = new ModelAndView("detalhesUsuario");
        mv.addObject("index", usuario);
        return mv;
    }
}
