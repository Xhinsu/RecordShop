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
    public List<Album> getAllAlbums(){
        return  albumManagerService.getAllAlbums();
    }
    @GetMapping("/album/{id}")
    public Album getAlbumById(@PathVariable long id){
        return albumManagerService.getAlbumById(id) ;
    }

    @PatchMapping("/album/{id}")
    public Album patchAlbumById(@PathVariable long id){
        return  albumManagerService.updateAlbumById(id);
    }

    @GetMapping("/album/info/{album}")
    public Album getAlbumByAlbumName(@PathVariable String album){
        return albumManagerService.getAlbumByAlbumName(album) ;
    }
    @GetMapping("/album/year/{year}")
    public List<Album> getAlbumByYear(@PathVariable String year){
        return albumManagerService.getAlbumByYear(year) ;
    }

    @PostMapping("/album")
    public Album saveAlbum(@RequestBody Album album){
        return albumManagerService.saveAlbum(album);
    }

    @GetMapping("/genre")
    public String getAllGenres(){
        return  albumManagerService.getAllGenre();
    }

    @GetMapping("/genre/{genre}")
    public List<Album> getAlbumByGenre(@PathVariable String genre){
        return  albumManagerService.getAlbumByGenre(genre);
    }

    @GetMapping("/album/artist/{artist}")
    public List<Album> getAlbumByArtist(@PathVariable String artist){
        return  albumManagerService.getAlbumByArtist(artist);
    }


    @DeleteMapping("/album/{id}")
    public void getAlbumByArtist(@PathVariable long id){
        albumManagerService.deleteAlbumById(id);
    }
}
