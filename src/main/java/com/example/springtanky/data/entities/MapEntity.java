package com.example.springtanky.data.entities;

import jakarta.persistence.*;

@Entity
public class MapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mapId;

    @Column
    private String mapName;

    @Column
    private String camoType;

    @Column
    private String size;

    @Column
    private String description;

    @Column
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
