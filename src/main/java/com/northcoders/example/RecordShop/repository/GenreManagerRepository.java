package com.northcoders.example.RecordShop.repository;

import com.northcoders.example.RecordShop.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreManagerRepository extends CrudRepository<Genre, Long> {
}
