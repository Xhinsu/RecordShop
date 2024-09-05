package com.northcoders.example.RecordShop.service;

import com.northcoders.example.RecordShop.model.Album;
import com.northcoders.example.RecordShop.repository.AlbumManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumManagerServiceImpl implements AlbumManagerService {
    @Autowired
    AlbumManagerRepository albumManagerRepository;


    @Override
    public List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<>();
        try{
            albumManagerRepository.findAll().forEach(albums::add);
        }catch(NullPointerException e){
            System.err.println("Computer says no..");
        }
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
}
