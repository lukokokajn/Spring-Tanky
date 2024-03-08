package com.example.springtanky.controllers;

import com.example.springtanky.models.dto.FolderDTO;
import com.example.springtanky.models.dto.NameDTO;
import com.example.springtanky.models.services.FolderService;
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

    @GetMapping("create")
    public String renderName(@ModelAttribute NameDTO nameDTO) {
        return "pages/folder/create";
    }

    @PostMapping("create")
    public String createName(
            @Valid @ModelAttribute NameDTO name,
            BindingResult result,
            @PathVariable long folderId
    ) {
        if (result.hasErrors())
            return renderName(name);


        // Zde budeme později pracovat s databází
        System.out.println(name.getName()); // <-- TENTO ŘÁDEK NÁS ZAJÍMÁ
        nameService.create(name, folderId); // <-- Přidání článku do databáze

        return "redirect:/";
    }
    @GetMapping
    public String renderIndex(Model model) {
        List<NameDTO> nameDTOList = nameService.getAll();
        model.addAttribute("folder", nameDTOList);

        return "pages/home/index";
    }

}
