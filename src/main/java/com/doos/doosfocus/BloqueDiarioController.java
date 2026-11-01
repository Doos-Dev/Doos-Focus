package com.doos.doosfocus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BloqueDiarioController {

    private final MetaRepository metaRepository;
    private final BloqueDiarioRepository bloqueRepository;

    public BloqueDiarioController(MetaRepository metaRepository,
                                  BloqueDiarioRepository bloqueRepository) {
        this.metaRepository = metaRepository;
        this.bloqueRepository = bloqueRepository;
    }

    @GetMapping("/metas/{metaId}/dias")
    public String listar(@PathVariable("metaId") Long metaId, Model model) {
        Meta90Dias meta = metaRepository.findById(metaId).orElseThrow();
        List<BloqueDiario> dias = bloqueRepository.findByMetaIdOrderByFechaAsc(metaId);

        BloqueDiario nuevo = new BloqueDiario();
        nuevo.setFecha(LocalDate.now());

        model.addAttribute("meta", meta);
        model.addAttribute("dias", dias);
        model.addAttribute("cumplidos", dias.stream().filter(BloqueDiario::isCumplido).count());
        model.addAttribute("nuevoDia", nuevo);
        return "dias";
    }

    @PostMapping("/metas/{metaId}/dias")
    public String crear(@PathVariable("metaId") Long metaId,
                        @ModelAttribute("nuevoDia") BloqueDiario dia,
                        RedirectAttributes redirect) {
        if (bloqueRepository.existsByMetaIdAndFecha(metaId, dia.getFecha())) {
            redirect.addFlashAttribute("error", "Ya registraste ese día. Elige otra fecha.");
            return "redirect:/metas/" + metaId + "/dias";
        }
        Meta90Dias meta = metaRepository.findById(metaId).orElseThrow();
        dia.setMeta(meta);
        bloqueRepository.save(dia);
        return "redirect:/metas/" + metaId + "/dias";
    }
}