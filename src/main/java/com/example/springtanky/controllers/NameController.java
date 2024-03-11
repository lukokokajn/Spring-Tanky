package com.example.springtanky.controllers;

import com.example.springtanky.models.dto.NameDTO;
import com.example.springtanky.models.services.NameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/name")
public class NameController {

    @Autowired
    private NameService nameService;

    @GetMapping("create/{folderId}")
    public String renderName(@ModelAttribute NameDTO nameDTO, @PathVariable long folderId, Model model) {
        model.addAttribute("foderId", folderId);
        return "pages/name/create";
    }

    @PostMapping("create/{folderId}")
    public String createName(
            @Valid @ModelAttribute NameDTO name,
            BindingResult result,
            @PathVariable long folderId, Model model
    ) {
        if (result.hasErrors())
            return renderName(name, folderId, model);
        nameService.create(name, folderId);
        return "redirect:/";
    }

    @GetMapping
    public String renderIndex(Model model) {
        List<NameDTO> nameDTOList = nameService.getAll();
        model.addAttribute("folder", nameDTOList);
        return "pages/home/index";
    }

}
