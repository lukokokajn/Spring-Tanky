package com.example.springtanky.models.dto;

public class PlayerStatsDTO {
    private int maxXP;
    private int treesCut;

    // Gettery a settery

    public PlayerStatsDTO() {
    }

    public PlayerStatsDTO(int maxXP, int treesCut) {
        this.maxXP = maxXP;
        this.treesCut = treesCut;
    }

    public int getMaxXP() {
        return maxXP;
    }

    public void setMaxXP(int maxXP) {
        this.maxXP = maxXP;
    }

    public int getTreesCut() {
        return treesCut;
    }

    public void setTreesCut(int treesCut) {
        this.treesCut = treesCut;
    }
}