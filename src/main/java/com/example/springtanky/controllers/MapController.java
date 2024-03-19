package com.example.springtanky.controllers;

import com.example.springtanky.models.dto.FolderDTO;
import com.example.springtanky.models.dto.MapDTO;
import com.example.springtanky.models.services.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MapController {
    @Autowired
    MapService mapService;
    @GetMapping("/maps")
    public String renderIndex(Model model) {
        List<MapDTO> mapDTOList = mapService.getAll();
        model.addAttribute("map", mapDTOList);
        return "pages/home/maps";
    }
}
