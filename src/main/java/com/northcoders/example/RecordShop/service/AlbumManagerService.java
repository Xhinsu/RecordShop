package com.northcoders.example.RecordShop.service;

import com.northcoders.example.RecordShop.model.Album;
import com.northcoders.example.RecordShop.model.Genre;
import com.northcoders.example.RecordShop.repository.AlbumManagerRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.PrivateKey;
import java.util.List;

public interface AlbumManagerService {
    List<Album> getAllAlbums();
    Album getAlbumById(long id);
    Album saveAlbum(Album album);


    List<Genre> getAllGenres();
    Genre saveGenre(Genre genre);

}
