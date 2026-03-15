package com.stockmasters.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stockmasters.app.repository.CenterRepository;

@Controller
public class CenterController {

    private final CenterRepository repo;

    public CenterController(CenterRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/centers")
    public String centers(Model model) {

        model.addAttribute("centers", repo.findAll());

        return "centers";
    }
}
