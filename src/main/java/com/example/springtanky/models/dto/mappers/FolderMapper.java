package com.example.springtanky.models.dto.mappers;

import com.example.springtanky.data.entities.FolderEntity;
import com.example.springtanky.models.dto.FolderDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface FolderMapper {
    FolderEntity toEntity(FolderDTO source);

    FolderDTO toDTO(FolderEntity source);

}
