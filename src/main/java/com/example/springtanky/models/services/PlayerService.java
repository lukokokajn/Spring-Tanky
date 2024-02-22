package com.example.springtanky.models.services;

import com.example.springtanky.configuration.WOTConfig;
import com.example.springtanky.models.dto.PlayerDTO;
import com.example.springtanky.models.dto.PlayerStatsDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlayerService {

    @Autowired
    private WOTConfig wotConfig;

    public PlayerDTO getPlayerInfo(String playerName) {
        String apiUrl = wotConfig.getWotApiUrl(playerName);

        // Vytvoření instance RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Vykonání GET požadavku a získání odpovědi
        String response = restTemplate.getForObject(apiUrl, String.class);

        try {
            // Zpracování JSON odpovědi
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);

            // Získání player ID a player Nickname
            JsonNode playerNode = root.path("data").path(0);

            if (playerNode.isMissingNode()) {
                return null; // Hráč nebyl nalezen
            } else {
                int playerID = playerNode.path("account_id").asInt();
                String playerNickname = playerNode.path("nickname").asText();
                return new PlayerDTO(playerID, playerNickname);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}