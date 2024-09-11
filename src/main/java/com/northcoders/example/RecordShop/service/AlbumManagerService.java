package com.northcoders.example.RecordShop.service;

import com.northcoders.example.RecordShop.model.Album;
import com.northcoders.example.RecordShop.repository.AlbumManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.PrivateKey;
import java.time.LocalDate;
import java.util.List;

public interface AlbumManagerService {
    List<Album> getAllAlbums();
    Album getAlbumById(long id);
    Album saveAlbum(Album album);
    String getAllGenre();
    Album updateAlbum(Album album, long id);

    List<Album> getAlbumByGenre(String genre);
    List<Album>getAlbumByArtist(String artist);
    Album getAlbumByAlbumName(String album);

    List<Album> getAlbumByYear(String date);

    void deleteAlbumById(long id);

}
