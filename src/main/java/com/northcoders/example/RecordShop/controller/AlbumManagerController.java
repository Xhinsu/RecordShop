package com.northcoders.example.RecordShop.controller;

import com.northcoders.example.RecordShop.service.AlbumManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.northcoders.example.RecordShop.model.Album;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AlbumManagerController {
    @Autowired
    AlbumManagerServiceImpl albumManagerService;

    @GetMapping("/album")
    public List<Album> getAll(){
        return  albumManagerService.getAllAlbums();
    }
    @GetMapping("/album/{id}")
    public Album getAlbumById(@PathVariable long id){
        return albumManagerService.getAlbumById(id) ;
    }

    @PostMapping("/album")
    public Album saveAlbum(@RequestBody Album album){
        return albumManagerService.saveAlbum(album);
    }

}
