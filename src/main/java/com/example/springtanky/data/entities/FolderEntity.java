package com.example.springtanky.data.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "folders")
public class FolderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long folderId;

    @Column
    private String folderName;

    @ManyToOne()
    private UserEntity userEntities;

    @OneToMany(mappedBy = "names")
    private List<NameEntity> nameEntities;

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

    public List<NameEntity> getNameEntities() {
        return nameEntities;
    }

    public void setNameEntities(List<NameEntity> nameEntities) {
        this.nameEntities = nameEntities;
    }
    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

}
