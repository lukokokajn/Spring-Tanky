package com.example.springtanky.models.services;

import com.example.springtanky.models.dto.FolderDTO;

import java.util.List;

public interface FolderService {
    void deleteFolder(long folderId);
    void create(FolderDTO folder);
    List<FolderDTO> getAll();

}
