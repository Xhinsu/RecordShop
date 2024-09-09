package com.northcoders.example.RecordShop.repository;

import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

import com.northcoders.example.RecordShop.model.Album;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumManagerRepository extends CrudRepository<Album, Long> {
}
