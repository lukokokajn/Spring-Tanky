package com.example.springtanky.data.repositories;

import com.example.springtanky.controllers.MapController;
import com.example.springtanky.data.entities.MapEntity;
import org.springframework.data.repository.CrudRepository;

public interface MapRepository extends CrudRepository<MapEntity, Long> {
}
