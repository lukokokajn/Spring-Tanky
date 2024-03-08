package com.example.springtanky.models.services;

import com.example.springtanky.data.entities.FolderEntity;
import com.example.springtanky.data.entities.UserEntity;
import com.example.springtanky.data.repositories.FolderRepository;
import com.example.springtanky.data.repositories.UserRepository;
import com.example.springtanky.models.dto.FolderDTO;
import com.example.springtanky.models.dto.mappers.FolderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FolderServiceImpl implements FolderService {

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private FolderMapper folderMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void deleteFolder(long folderId) {
        folderRepository.deleteById(folderId);
    }

    @Override
    public void create(FolderDTO folder) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String singedUserUsername = authentication.getName();
        UserEntity user = userRepository.findByEmail(singedUserUsername).get();
        FolderEntity newFolder = folderMapper.toEntity(folder); // <-- Tímto řádkem jsme nahradili velkou část obsahu této metody
        user.getFolders().add(folderMapper.toEntity(folder));
        newFolder.setUserEntities(user);
        userRepository.save(user);
        folderRepository.save(newFolder);
    }

    @Override
    public List<FolderDTO> getAll() {
        List<FolderDTO> folderDTOList = new ArrayList<>();

        Iterable<FolderEntity> fetchedArticles = folderRepository.findAll();
        for (FolderEntity folderEntity : fetchedArticles) {
            FolderDTO mappedFolder = folderMapper.toDTO(folderEntity);
            folderDTOList.add(mappedFolder);
        }

        return folderDTOList;
    }
}
