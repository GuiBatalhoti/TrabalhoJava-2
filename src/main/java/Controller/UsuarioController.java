/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import Repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository ur;
    
    @RequestMapping("/user")
    public String formUser() {
        return "formCadastroUsuario";
    }
    
    //Redireciona a requisição HTTP para esse método
    @RequestMapping("/cadastrarUsuario") 
    public String formCadastroUsuario() {
        return "formCadastroUsuario";
    }

    @PostMapping("/cadastrarUsuario")
    public String formCadastroUsuario(@Valid Usuario usuario,
            BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute(
                    "mensagem", "Usuario inválido!");
            return "redirect:/cadastrarUsuario";
        }
        ur.save(usuario);
        return "redirect:/user";
    }
    
    @RequestMapping("/{username}")
    public ModelAndView detalhesManga(@PathVariable("username") String username) {
        Usuario usuario = ur.findByUsername(username);
        ModelAndView mv = new ModelAndView("detalhesManga");
        mv.addObject("usuario", usuario);
        return mv;
    }
}
