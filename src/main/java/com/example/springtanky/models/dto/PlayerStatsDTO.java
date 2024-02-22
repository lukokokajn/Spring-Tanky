package com.example.springtanky.models.dto;

public class PlayerStatsDTO {
    private int maxXP;
    private int treesCut;
    private int victories;
    private int defeats;
    private int draws;
    private long damageDealt;
    private int globalRating;
    private int frags;

    // Gettery a settery

    public PlayerStatsDTO(int maxXP, int treesCut, int victories, int defeats, int draws, long damageDealt, int globalRating, int frags) {
        this.maxXP = maxXP;
        this.treesCut = treesCut;
        this.victories = victories;
        this.defeats = defeats;
        this.draws = draws;
        this.damageDealt = damageDealt;
        this.globalRating = globalRating;
        this.frags = frags;
    }

    // Metoda pro výpočet Winrate
    public double getWinrate() {
        int totalBattles = victories + defeats + draws;

        if (totalBattles == 0) {
            return 0.0;
        }
        double winrate = ((double) victories / totalBattles) * 100;

        return Math.round(winrate * 100.0) / 100.0; // Zaokrouhlení na dvě desetinná místa
    }

    public long getAvgDmg(){
        long totalBattles = victories + defeats + draws;

        if (totalBattles == 0) {
            return 0;
        }

        return damageDealt / totalBattles;
    }

    public double getAvgFrags(){
        long totalBattles = victories + defeats + draws;

        if (totalBattles == 0) {
            return 0;
        }
        double avgFrag = ((double) frags / totalBattles);

        return Math.round(avgFrag * 100.0) / 100.0; // Zaokrouhlení na dvě desetinná místa
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

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public long getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(long damageDealt) {
        this.damageDealt = damageDealt;
    }

    public int getGlobalRating() {
        return globalRating;
    }

    public void setGlobalRating(int globalRating) {
        this.globalRating = globalRating;
    }

    public int getFrags() {
        return frags;
    }

    public void setFrags(int frags) {
        this.frags = frags;
    }
}