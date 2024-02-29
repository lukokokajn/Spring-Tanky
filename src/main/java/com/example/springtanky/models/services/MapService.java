package com.example.springtanky.models.services;

import com.example.springtanky.data.entities.MapEntity;
import com.example.springtanky.data.repositories.MapRepository;
import com.example.springtanky.models.dto.MapDTO;
import com.example.springtanky.models.dto.mappers.MapMapper;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapService {

    @Autowired
    private MapRepository mapRepository;

    @Autowired
    private MapMapper mapMapper;
    public List<MapDTO> getAll(){
        List<MapEntity> maps  = (List<MapEntity>) mapRepository.findAll();
        return maps.stream().map(i -> mapMapper.toDTO(i)).collect(Collectors.toList());
    }

}
