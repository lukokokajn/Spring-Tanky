package com.example.springtanky.data.repositories;

import com.example.springtanky.data.entities.NameEntity;
import com.example.springtanky.data.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface NameRepository extends CrudRepository<NameEntity, Long> {
}
