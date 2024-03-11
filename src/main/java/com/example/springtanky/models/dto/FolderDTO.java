package com.example.springtanky.models.dto;

import com.example.springtanky.data.entities.NameEntity;
import com.example.springtanky.data.entities.UserEntity;
import jakarta.persistence.*;

import java.util.List;

public class FolderDTO {

    private long folderId;

    private String folderName;

    private UserEntity userEntities;

    private List<NameDTO> nameEntities;

    public long getFolderId() {
        return folderId;
    }

    public void setFolderId(long folderId) {
        this.folderId = folderId;
    }

    public UserEntity getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(UserEntity userEntities) {
        this.userEntities = userEntities;
    }
    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public List<NameDTO> getNameEntities() {
        return nameEntities;
    }

    public void setNameEntities(List<NameDTO> nameEntities) {
        this.nameEntities = nameEntities;
    }
}
