package com.northcoders.example.RecordShop.service;

import com.northcoders.example.RecordShop.model.Album;
import com.northcoders.example.RecordShop.model.Genre;
import com.northcoders.example.RecordShop.repository.AlbumManagerRepository;
import com.northcoders.example.RecordShop.repository.GenreManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumManagerServiceImpl implements AlbumManagerService {
    @Autowired
    AlbumManagerRepository albumManagerRepository;

    @Autowired
    GenreManagerRepository genreManagerRepository;



    @Override
    public List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<>();
//        try{
            albumManagerRepository.findAll().forEach(albums::add);
//        }catch(NullPointerException e){
//            System.err.println("Computer says no..");
//        }
        return albums;
    }

    @Override
    public Album getAlbumById(long id) {
        return albumManagerRepository.findById(id)
                .orElse(null);

    }
    @Override
    public Album saveAlbum(Album album) {
        return albumManagerRepository.save(album);

    }

    @Override
    public List<Genre> getAllGenres() {
        List<Genre>genres = new ArrayList<>();
//        try{
        genreManagerRepository.findAll().forEach(genres::add);
//        }catch(NullPointerException e){
//            System.err.println("Computer says no..");
//        }
        return genres;    }

    @Override
    public Genre saveGenre(Genre genre) {
        return genreManagerRepository.save(genre);
    }
}
