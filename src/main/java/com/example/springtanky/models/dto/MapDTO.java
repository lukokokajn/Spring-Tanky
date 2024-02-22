package com.example.springtanky.models.dto;

import jakarta.persistence.Column;

public class MapDTO {
    private long mapId;
    private String mapName;
    private String camoType;
    private String size;
    private String description;
    private String mapImgUrl;

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getCamoType() {
        return camoType;
    }

    public void setCamoType(String camoType) {
        this.camoType = camoType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMapImgUrl() {
        return mapImgUrl;
    }

    public void setMapImgUrl(String mapImgUrl) {
        this.mapImgUrl = mapImgUrl;
    }
}
