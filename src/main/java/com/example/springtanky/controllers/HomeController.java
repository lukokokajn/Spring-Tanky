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

    @GetMapping("/maps")
    public String renderContact() {
        return "pages/home/maps";
    }

    @Autowired
    private PlayerService playerService;

    @GetMapping("/search")
    public String searchPlayer(@RequestParam String playerName, Model model) {
        PlayerDTO playerDTO = playerService.getPlayerInfo(playerName);

        if (playerDTO == null) {
            model.addAttribute("message", "Hráč s jménem '" + playerName + "' nebyl nalezen.");
        } else {
            model.addAttribute("player", playerDTO);

            // Získání dodatečných statistik hráče
            PlayerStatsDTO playerStatsDTO = playerService.getPlayerStats(playerDTO.getPlayerID());
            if (playerStatsDTO != null) {
                model.addAttribute("maxXP", playerStatsDTO.getMaxXP());
                model.addAttribute("treesCut", playerStatsDTO.getTreesCut());
                model.addAttribute("victories", playerStatsDTO.getVictories());
                model.addAttribute("defeats", playerStatsDTO.getDefeats());
                model.addAttribute("draws", playerStatsDTO.getDraws());
                model.addAttribute("winrate", playerStatsDTO.getWinrate());
                model.addAttribute("damageDealt", playerStatsDTO.getDamageDealt());
                model.addAttribute("avgDamage", playerStatsDTO.getAvgDmg());
                model.addAttribute("globalRating", playerStatsDTO.getGlobalRating());
                model.addAttribute("frags", playerStatsDTO.getFrags());
                model.addAttribute("avgFrags", playerStatsDTO.getAvgFrags());


            }
        }
        // Návrat na Thymeleaf šablonu
        return "pages/home/search_result";
    }


}
