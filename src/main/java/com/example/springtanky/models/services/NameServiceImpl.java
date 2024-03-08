package com.example.springtanky.models.services;

import com.example.springtanky.data.entities.FolderEntity;
import com.example.springtanky.data.entities.NameEntity;
import com.example.springtanky.data.entities.UserEntity;
import com.example.springtanky.data.repositories.FolderRepository;
import com.example.springtanky.data.repositories.NameRepository;
import com.example.springtanky.models.dto.FolderDTO;
import com.example.springtanky.models.dto.NameDTO;
import com.example.springtanky.models.dto.mappers.FolderMapper;
import com.example.springtanky.models.dto.mappers.NameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

@Service
public class NameServiceImpl implements NameService {

    @Autowired
    private NameRepository nameRepository;

    @Autowired
    private NameMapper nameMapper;

    @Autowired
    private FolderRepository folderRepository;

    @Override
    public void create(NameDTO name, long folderId) {
        FolderEntity folder = folderRepository.findById(folderId).get();
        NameEntity newName = nameMapper.toEntity(name); // <-- Tímto řádkem jsme nahradili velkou část obsahu této metody
        name.getNames().add(nameMapper.toEntity(name));
        folderRepository.save(folder);
        nameRepository.save(newName);}

    @Override
    public List<NameDTO> getAll() {
        List<NameDTO> folderDTOList = new ArrayList<>();

        Iterable<NameEntity> fetchedName = nameRepository.findAll();
        for (NameEntity nameEntity : fetchedName) {
            NameDTO mappedName = nameMapper.toDTO(nameEntity);
            folderDTOList.add(mappedName);
        }

        return folderDTOList;
    }
}
