/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Controller;

import Main.Model.Manga;
import Main.Model.MangaList;
import Main.Model.MangaListPK;
import Main.Model.Users;
import Main.Repository.MangaListRepository;
import Main.Repository.MangaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ListaController {
    
    @Autowired
    private MangaRepository mr;
    
    @Autowired
    private MangaListRepository mlr;
    
    @GetMapping("/followManga/{idManga}")
    public String followManga(@PathVariable("idManga") int idManga) {
        MangaList mangaList = new MangaList();
        Manga manga = mr.findByIdManga(idManga);
        //associa o manga para a lista
        
        Object principal = SecurityContextHolder. getContext().getAuthentication().getPrincipal();
        //associa o manga ao usuario
        Users user = (Users) principal;
        MangaListPK mlPK = new MangaListPK(user.getIdUser(), idManga);
        mangaList.setMangaListPK(mlPK);
        mangaList.setUsers(user);
        mangaList.setManga(manga);
        mlr.save(mangaList);
        return "redirect:/lista";
    }
    
    @GetMapping("/usuario/meusManga/{idManga}")
    public ModelAndView updateMangaList(@PathVariable("idManga") int idManga) {
        //busca a lista pelo id do usuario e do manga
        Object principal = SecurityContextHolder. getContext().getAuthentication().getPrincipal();
        Users user = (Users) principal;
        MangaListPK mlPK = new MangaListPK(user.getIdUser(), idManga);
        MangaList mangaList = mlr.findByMangaListPK(mlPK);      
        
        //recupera o manga que a lista referencia
        Manga manga = mr.findByIdManga(idManga);

        //cria um ModelAndView com o mangaList encontrado
        ModelAndView mv = new ModelAndView("mangaList");
        mv.addObject("mangaList", mangaList);
        mv.addObject("manga", manga);
        
        return mv;
    }
    
    @PostMapping("/updateMangaList")
    public String updateMangaList(@Valid MangaList mangaList, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "redirect:/lista";
        }
        mlr.save(mangaList);
        return "redirect:/lista";
    }
    
    @GetMapping("/usuario/meusManga")
    public ModelAndView myList() {
        //busca a lista pelo id do usuario e do manga
        Object principal = SecurityContextHolder. getContext().getAuthentication().getPrincipal();
        Users user = (Users) principal;
        MangaListPK mlPK = new MangaListPK(user.getIdUser(), idManga);
        MangaList mangaList = mlr.findByMangaListPK(mlPK);      
        
        //recupera o manga que a lista referencia
        Manga manga = mr.findByIdManga(idManga);

        //cria um ModelAndView com o mangaList encontrado
        ModelAndView mv = new ModelAndView("mangaList");
        mv.addObject("mangaList", mangaList);
        mv.addObject("manga", manga);
        
        return mv;
    }
}
