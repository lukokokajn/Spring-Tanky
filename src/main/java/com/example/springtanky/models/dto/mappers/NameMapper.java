package com.example.springtanky.models.dto.mappers;

import com.example.springtanky.data.entities.FolderEntity;
import com.example.springtanky.data.entities.NameEntity;
import com.example.springtanky.models.dto.FolderDTO;
import com.example.springtanky.models.dto.NameDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface NameMapper {
    NameEntity toEntity(NameDTO source);

    NameDTO toDTO(NameEntity source);
}
