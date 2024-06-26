package com.example.springtanky.models.services;

import com.example.springtanky.models.dto.PlayerStatsDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlayerStatsService {
    public PlayerStatsDTO getPlayerStats(int playerID) {
        String statsUrl = "https://api.worldoftanks.eu/wot/account/info/?application_id=ce177e37ee1681b6a38f65598995e724&account_id=" + playerID;

        // Vytvoření instance RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Vykonání GET požadavku a získání odpovědi
        String response = restTemplate.getForObject(statsUrl, String.class);

        try {
            // Zpracování JSON odpovědi
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            JsonNode playerNode = root.path("data").path(String.valueOf(playerID));

            if (playerNode.isMissingNode()) {
                return null; // Hráč nebyl nalezen
            } else {
                // Získání statistik hráče
                JsonNode statsNodeAll = playerNode.path("statistics").path("all");
                int maxXP = statsNodeAll.path("max_xp").asInt();
                int victories = statsNodeAll.path("wins").asInt();
                int defeats = statsNodeAll.path("losses").asInt();
                int draws = statsNodeAll.path("draws").asInt();
                int damageDealt = statsNodeAll.path("damage_dealt").asInt();
                int frags = statsNodeAll.path("frags").asInt();

                JsonNode statsNodeStats = playerNode.path("statistics");
                int treesCut = statsNodeStats.path("trees_cut").asInt();

                int globalRating = playerNode.path("global_rating").asInt();

                return new PlayerStatsDTO(maxXP, treesCut, victories, defeats, draws, damageDealt, globalRating, frags);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
