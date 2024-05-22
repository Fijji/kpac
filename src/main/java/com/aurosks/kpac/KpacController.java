package com.aurosks.kpac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class KpacController {

    @Autowired
    private KpacDao kpacDao;

    @GetMapping("/kpacs")
    public String listKpacs(Model model) {
        List<Kpac> kpacs = kpacDao.getAllKpacs();
        model.addAttribute("kpacs", kpacs);
        return "kpacs";
    }

    @GetMapping("/kpacs/{id}")
    public String getKpac(@PathVariable Long id, Model model) {
        Kpac kpac = kpacDao.getKpacById(id);
        model.addAttribute("kpac", kpac);
        return "kpac";
    }

    @GetMapping("/kpacs/new")
    public String showAddForm(Model model) {
        model.addAttribute("kpac", new Kpac());
        return "kpac-form";
    }

    @PostMapping("/kpacs")
    public String addKpac(@ModelAttribute("kpac") Kpac kpac) {
        kpacDao.addKpac(kpac);
        return "redirect:/kpacs";
    }

    @PostMapping("/kpacs/{id}/edit")
    public String updateKpac(@PathVariable Long id, @ModelAttribute("kpac") Kpac kpac) {
        kpac.setId(id);
        kpacDao.updateKpac(kpac);
        return "redirect:/kpacs";
    }

    @GetMapping("/kpacs/{id}/delete")
    public String deleteKpac(@PathVariable Long id) {
        kpacDao.deleteKpac(id);
        return "redirect:/kpacs";
    }
}