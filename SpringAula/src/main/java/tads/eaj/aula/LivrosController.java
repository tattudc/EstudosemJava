package tads.eaj.aula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class LivrosController {
    LivrosService livrosService;

    @Autowired
    public void setLivrosService(LivrosService livrosService) {
        this.livrosService = livrosService;
    }

    @RequestMapping("/")
    public String getHome(Model model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("opa", "Aula");
        Cookie[] cookie = request.getCookies();
        for(int i = 0; i < cookie.length; i++){
            if(cookie[i].getName().equals("tempo")) {
                List<Livros> livrosList = livrosService.findAll();
                model.addAttribute("livrosList", livrosList);
                model.addAttribute("cookie", cookie[i].getValue());
                return "index";
            }
        }
        //Cookie c = new Cookie("tempo", "Tarcisio");
        //response.addCookie(c);
        return "redirect:/setcookies";
    }

    @RequestMapping("/cadastrar")
    public String getPageCadastro(Model model) {
        var livros = new Livros();
        model.addAttribute("livros", livros);
        return "cadastrar";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String addLivros(@ModelAttribute @Valid Livros livros, Errors erros) {

        if(erros.hasErrors()){
            return "cadastrar";
        }else{
            livrosService.add(livros);
            return "redirect:/";
        }
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView editarLivros(@PathVariable(name = "id") Long id) {
        var modelLandView = new ModelAndView("editar");
        var livros = livrosService.get(id);
        modelLandView.addObject("livros", livros);
        return modelLandView;
    }

    @RequestMapping("/deletar/{id}")
    public String deleteLivro(@PathVariable(name = "id") Long id) {
        livrosService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/setcookies")
    public String gravaCookies(HttpServletResponse response, HttpServletRequest request){
        Cookie c = new Cookie("tempo", "Tarcisio");
        HttpSession session = request.getSession();
        Date lastAccess = new Date(session.getLastAccessedTime());
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy|hh:mm:ss");
        String strDate = dateFormat.format(lastAccess);
        c.setValue(strDate);
        response.addCookie(c);
        return "redirect:/";
    }

    @RequestMapping("/readcookies")
    public String gravaCookies(@CookieValue(value = "tempo", defaultValue = "Taniro") String nome){
        System.out.println(nome);
        return "cookies";
    }
}
