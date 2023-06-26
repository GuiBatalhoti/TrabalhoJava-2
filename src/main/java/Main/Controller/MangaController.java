package Main.Controller;

import Main.Model.Manga;
import Main.Repository.MangaRepository;
import jakarta.validation.Valid;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Classe responsável por controlar as requisições HTTP relacionadas ao mangá.
 *
 * @author - GuiBatalhoti
 * @author - Gabriel Nozawa
 */
@Controller
public class MangaController {

    /**
     * Atributo responsável por injetar a dependência do repositório do mangá.
     */
    @Autowired
    private MangaRepository mr;
    
    /**
     * Método responsável por retornar a página de cadastro de mangá.
     * @param model
     * @return
     */
    @GetMapping("/addManga")
    public String formRegistration(Model model) {
        model.addAttribute("manga", new Manga());
        return "addManga";
    }

    @GetMapping("/addMangaSuccess")
    public String formRegistrationSuccess() {
        return "addMangaSuccess";
    }

    /**
     * Método responsável por cadastrar um mangá.
     * @param manga
     * @param result
     * @param attributes
     * @return retorna a página de cadastro de mangá.
     */
    @PostMapping("/addMangaSuccess")
    public String formRegistration(@Valid Manga manga, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/addManga";
        }
        mr.save(manga);
        attributes.addFlashAttribute("mensagem", "Mangá cadastrado com sucesso!");
        return "redirect:/lista";
    }

    /**
     * Método responsável por retornar a página de edição de mangá.
     * @return Model and View
     */
    @RequestMapping("/manga")
    public ModelAndView listaManga() {
        ModelAndView mv = new ModelAndView("teste");
        Iterable<Manga> mangas = mr.findAll();
        mv.addObject("manga", mangas);

        return mv;
    }

    /**
     * Método responsável por retornar a página de edição de mangá.
     * @return Model and View
     */
    @RequestMapping("/todosManga")
    public ModelAndView todosManga() {
        ModelAndView mv = new ModelAndView("teste");
        Iterable<Manga> itManga = mr.findAll();
        mv.addObject("itManga", itManga);
        return mv;
    }

    /**
     * Método responsável por retornar a página de edição de mangá.
     * @param idManga
     * @return Model and View
     */
    @RequestMapping("/manga/{idManga}")
    public ModelAndView detalhesManga(@PathVariable("idManga") long idManga) {
        Manga manga = mr.findByIdManga(idManga);
        ModelAndView mv = new ModelAndView("detalhesManga");
        mv.addObject("manga", manga);
        return mv;
    }

    /**
     * Método responsável por retornar a página de edição de mangá.
     * @return Model and View
     */
    @RequestMapping("/lista")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("lista");
        Iterable<Manga> itManga = mr.findAll();
        mv.addObject("itManga", itManga);
        return mv;
    }
}
