package com.example.springtanky.models.services;

import com.example.springtanky.models.dto.NameDTO;

import java.util.List;

public interface NameService {
    void create(NameDTO name, long folderId);
    List<NameDTO> getAll();

}
