package com.example.springtanky.controllers;

import com.example.springtanky.models.dto.PlayerDTO;
import com.example.springtanky.models.dto.PlayerStatsDTO;
import com.example.springtanky.models.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {
    @GetMapping("/")
    public String renderIndex() {
        return "pages/home/index";
    }



}
