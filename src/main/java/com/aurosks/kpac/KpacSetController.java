package com.aurosks.kpac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class KpacSetController {

    @Autowired
    private KpacSetDao kpacSetDao;

    @GetMapping("/sets")
    public String listKpacSets(Model model) {
        List<KpacSet> kpacSets = kpacSetDao.getAllKpacSets();
        model.addAttribute("kpacSets", kpacSets);
        return "sets";
    }

    @GetMapping("/sets/{id}")
    public String getKpacSet(@PathVariable("id") Long id, Model model) {
        KpacSet kpacSet = kpacSetDao.getKpacSetById(id);
        model.addAttribute("kpacSet", kpacSet);
        return "kpacSet";
    }

    @PostMapping("/sets")
    public String addKpacSet(@ModelAttribute KpacSet kpacSet) {
        kpacSetDao.addKpacSet(kpacSet);
        return "redirect:/sets";
    }

    @PutMapping("/sets/{id}")
    public String updateKpacSet(@PathVariable("id") Long id, @ModelAttribute KpacSet kpacSet) {
        kpacSet.setId(id);
        kpacSetDao.updateKpacSet(kpacSet);
        return "redirect:/sets";
    }

    @DeleteMapping("/sets/{id}")
    public String deleteKpacSet(@PathVariable("id") Long id) {
        kpacSetDao.deleteKpacSet(id);
        return "redirect:/sets";
    }
}
