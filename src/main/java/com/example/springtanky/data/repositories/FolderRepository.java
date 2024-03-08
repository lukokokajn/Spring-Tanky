package com.example.springtanky.data.repositories;

import com.example.springtanky.data.entities.FolderEntity;
import com.example.springtanky.data.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface FolderRepository extends CrudRepository<FolderEntity, Long> {
}

