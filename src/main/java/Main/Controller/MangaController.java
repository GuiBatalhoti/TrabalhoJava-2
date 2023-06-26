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

@Controller
public class MangaController {
    @Autowired
    private MangaRepository mr;
    
    //Redireciona a requisição HTTP para esse método
    @GetMapping("/addManga")
    public String formRegistration(Model model) {
        model.addAttribute("manga", new Manga());
        return "addManga";
    }

    @GetMapping("/addMangaSuccess")
    public String formRegistrationSuccess() {
        return "addMangaSuccess";
    }

    @PostMapping("/addMangaSuccess")
    public String formRegistration(@Valid Manga manga, BindingResult result, RedirectAttributes attributes) {
        System.out.println(manga.getPublicationDate());
//        SimpleDateFormat dateParser = new SimpleDateFormat ("dd/MM/yyyy");
//        manga.getDate()
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/addManga";
        }
        mr.save(manga);
        attributes.addFlashAttribute("mensagem", "Mangá cadastrado com sucesso!");
        return "redirect:/lista";
    }
    
    @RequestMapping("/manga")
    public ModelAndView listaManga() {
        ModelAndView mv = new ModelAndView("teste");
        Iterable<Manga> mangas = mr.findAll();
        mv.addObject("manga", mangas);

        return mv;
    }
    
    @RequestMapping("/todosManga")
    public ModelAndView todosManga() {
        ModelAndView mv = new ModelAndView("teste");
        Iterable<Manga> itManga = mr.findAll();
        mv.addObject("manga", itManga);
        return mv;
    }

    @RequestMapping("/manga/{idManga}")
    public ModelAndView detalhesManga(@PathVariable("idManga") long idManga) {
        Manga manga = mr.findByIdManga(idManga);
        ModelAndView mv = new ModelAndView("detalhesManga");
        mv.addObject("manga", manga);
        return mv;
    }
}
