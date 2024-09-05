package com.northcoders.example.RecordShop.repository;

import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

import com.northcoders.example.RecordShop.model.Album;

public interface AlbumManagerRepository extends CrudRepository<Album, Long> {
}
