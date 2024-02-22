package com.example.springtanky.models.dto;

public class PlayerDTO {
    private int playerID;
    private String playerNickname;

    // Konstruktor, gettery a settery


    public PlayerDTO(int playerID, String playerNickname) {
        this.playerID = playerID;
        this.playerNickname = playerNickname;
    }



    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerNickname() {
        return playerNickname;
    }

    public void setPlayerNickname(String playerNickname) {
        this.playerNickname = playerNickname;
    }
}
