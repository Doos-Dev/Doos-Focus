package com.doos.doosfocus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MetaController {

    private final MetaRepository metaRepository;

    public MetaController(MetaRepository metaRepository) {
        this.metaRepository = metaRepository;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/metas";
    }

    @GetMapping("/metas")
    public String listar(Model model) {
        model.addAttribute("metas", metaRepository.findAll());
        model.addAttribute("nuevaMeta", new Meta90Dias());
        return "metas";
    }

    @PostMapping("/metas")
    public String crear(@ModelAttribute("nuevaMeta") Meta90Dias meta) {
        if (meta.getFechaInicio() != null) {
            meta.setFechaFin(meta.getFechaInicio().plusDays(90));
        }
        metaRepository.save(meta);
        return "redirect:/metas";
    }
}