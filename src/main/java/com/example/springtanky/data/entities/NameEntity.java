package com.example.springtanky.data.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class NameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long nameId;

    @Column()
    private String name;

    @ManyToOne
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
