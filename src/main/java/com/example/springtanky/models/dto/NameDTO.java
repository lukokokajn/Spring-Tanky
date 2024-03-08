package com.example.springtanky.models.dto;

import com.example.springtanky.data.entities.FolderEntity;
import jakarta.persistence.*;

public class NameDTO {

    private long nameId;

    private String name;

    private FolderEntity names;

    public long getNameId() {
        return nameId;
    }

    public void setNameId(long nameId) {
        this.nameId = nameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FolderEntity getNames() {
        return names;
    }

    public void setNames(FolderEntity names) {
        this.names = names;
    }
}
