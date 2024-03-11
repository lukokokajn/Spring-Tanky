package com.example.springtanky.controllers;

import com.example.springtanky.models.dto.FolderDTO;
import com.example.springtanky.models.dto.PlayerDTO;
import com.example.springtanky.models.dto.PlayerStatsDTO;
import com.example.springtanky.models.services.FolderService;
import com.example.springtanky.models.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private FolderService folderService;

    @GetMapping()
    public String renderIndex(Model model) {
        List<FolderDTO> folderDTOList = folderService.getAll();
        model.addAttribute("folder", folderDTOList);

        return "pages/home/index";
    }



}
