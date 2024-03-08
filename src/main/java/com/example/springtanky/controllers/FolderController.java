package com.example.springtanky.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.springtanky.models.dto.FolderDTO;
import com.example.springtanky.models.services.FolderService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/folder")
public class FolderController {

    @Autowired
    private FolderService folderService;

    @GetMapping("create")
    public String renderFolder(@ModelAttribute FolderDTO folderDTO) {
        return "pages/folder/create";
    }

    @PostMapping("create")
    public String createFolder(
            @Valid @ModelAttribute FolderDTO folder,
            BindingResult result
    ) {
        if (result.hasErrors())
            return renderFolder(folder);


        // Zde budeme později pracovat s databází
        System.out.println(folder.getFolderName()); // <-- TENTO ŘÁDEK NÁS ZAJÍMÁ
        folderService.create(folder); // <-- Přidání článku do databáze

        return "redirect:/";
    }

    @GetMapping
    public String renderIndex(Model model) {
        List<FolderDTO> folderDTOList = folderService.getAll();
        model.addAttribute("folder", folderDTOList);

        return "pages/home/index";
    }
}
