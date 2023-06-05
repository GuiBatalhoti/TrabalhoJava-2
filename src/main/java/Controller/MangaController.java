package Controller;

import Model.Manga;
import Repository.MangaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MangaController {
    @Autowired
    private MangaRepository mr;
    
    @RequestMapping("/acompanharManga") 
    public String formManga() {
        return "formManga";
    }

    @PostMapping("/acompanharManga")
    public String formManga(@Valid Manga manga,
            BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute(
                    "mensagem", "Verifique os campos!");
            return "redirect:/acompanharManga";
        }
        mr.save(manga);
        return "redirect:/meusManga";
    }
    
    @RequestMapping("/manga")
    public ModelAndView listaManga() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<Manga> eventos = mr.findAll();
        mv.addObject("eventos", eventos);

        return mv;
    }
    
    @RequestMapping("/todosManga")
    public ModelAndView todosManga() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<Manga> itManga = mr.findAll();
        mv.addObject("manga", itManga);

        return mv;
    }

    @RequestMapping("/{idManga}")
    public ModelAndView detalhesManga(@PathVariable("idManga") long idManga) {
        Manga manga = mr.findByIdEvento(idManga);
        ModelAndView mv = new ModelAndView("detalhesManga");
        mv.addObject("manga", manga);
        return mv;
    }
}
