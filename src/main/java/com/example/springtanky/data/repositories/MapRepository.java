package com.example.springtanky.data.repositories;

import com.example.springtanky.controllers.MapController;
import org.springframework.data.repository.CrudRepository;

public interface MapRepository extends CrudRepository<MapController, Long> {
}
