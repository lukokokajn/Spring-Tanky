package com.example.springtanky.controllers;

import com.example.springtanky.models.dto.PlayerDTO;
import com.example.springtanky.models.dto.PlayerStatsDTO;
import com.example.springtanky.models.services.PlayerService;
import com.example.springtanky.models.services.PlayerStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerStatsService playerStatsService;

    @GetMapping("/search")
    public String searchPlayer(@RequestParam String playerName, Model model, RedirectAttributes redirectAttributes) {
            PlayerDTO playerDTO = playerService.getPlayerInfo(playerName);
        if (playerDTO == null) {
            redirectAttributes.addFlashAttribute("userNotFound", "Uživatel neexistuje. 😣😣");
            return "redirect:";
        } else {
            model.addAttribute("player", playerDTO);

            // Získání dodatečných statistik hráče
            PlayerStatsDTO playerStatsDTO = playerStatsService.getPlayerStats(playerDTO.getPlayerID());
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
            // Návrat na Thymeleaf šablonu
            return "pages/home/search_result";
        }
    }
}
