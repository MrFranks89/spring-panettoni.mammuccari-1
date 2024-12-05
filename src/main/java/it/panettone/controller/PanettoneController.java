package it.panettone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import it.panettone.repository.PanettoneRepository;
import it.panettone.model.Panettone;

import java.util.List;

@Controller
@RequestMapping("/")
public class PanettoneController {
	
    private final PanettoneRepository panettoneRepo; 
    
    public PanettoneController(PanettoneRepository panettoneRepo) {
        this.panettoneRepo = panettoneRepo;
    }

    @GetMapping("/panettoni")
    public String index(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        List<Panettone> panettoni = (keyword == null) ? panettoneRepo.findAll()
                : panettoneRepo.findByNomeContaining(keyword);
        model.addAttribute("panettoni", panettoni);
        model.addAttribute("keyword", keyword);
        return "panettoni/index";
    }
    

    

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("panettone", new Panettone());
        return "panettoni/create";
    }

    @PostMapping("/create")
    public String store(@ModelAttribute Panettone panettone) {
        panettoneRepo.save(panettone);
        return "redirect:/panettoni";
    }
}