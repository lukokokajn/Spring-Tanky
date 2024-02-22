package com.example.springtanky.models.dto.mappers;

import com.example.springtanky.data.entities.MapEntity;
import com.example.springtanky.models.dto.MapDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapMapper {
    MapEntity toEntity(MapDTO source);
    MapDTO toDTO(MapEntity source);
}