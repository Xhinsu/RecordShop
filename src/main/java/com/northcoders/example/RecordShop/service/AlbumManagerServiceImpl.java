package com.northcoders.example.RecordShop.service;

import com.northcoders.example.RecordShop.model.Album;
import com.northcoders.example.RecordShop.repository.AlbumManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AlbumManagerServiceImpl implements AlbumManagerService {
    @Autowired
    AlbumManagerRepository albumManagerRepository;


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
    public String getAllGenre() {
        Set<String> allGenreSet = new HashSet<>();
        List<Album> getAlbums = getAllAlbums();
        getAlbums.forEach(s->allGenreSet.add(s.getGenre()));
        return allGenreSet.toString();
    }

    @Override
    public Album updateAlbum(Album album, long id) {
        Album findAlbum = getAlbumById(id);
        findAlbum = albumManagerRepository.save(album);
        return findAlbum;
    }

    @Override
    public List<Album> getAlbumByGenre(String genre) {
        List<Album> getAlbumsByGenre = getAllAlbums();
        List<Album> foundAlbumsByGenre = new ArrayList<>();
         getAlbumsByGenre.forEach(album-> {
            if (album.getGenre().equals(genre))
                foundAlbumsByGenre.add(album);
            });
         return foundAlbumsByGenre;
        }

    @Override
    public List<Album> getAlbumByArtist(String artist) {
        List<Album> getAlbumsByArtist = getAllAlbums();
        List<Album> foundAlbumsByArtist = new ArrayList<>();
        getAlbumsByArtist.forEach(album-> {
            if (album.getArtist().equals(artist))
                foundAlbumsByArtist.add(album);
        });
        return foundAlbumsByArtist;
    }

    @Override
    public Album getAlbumByAlbumName(String album) {
        List<Album> getAllAlbums = getAllAlbums();
        AtomicReference<Album> findAlbumByAlbumName = new AtomicReference<>(new Album());
        getAllAlbums.forEach(item-> {
            if (item.getName().equals(album))
                findAlbumByAlbumName.set(item);
        });
        return findAlbumByAlbumName.get();
    }

    @Override
    public List<Album> getAlbumByYear(String date) {
        List<Album> getAllAlbums = getAllAlbums();
        List<Album> albumsInTheYear = new ArrayList<>();

        getAllAlbums.forEach(album->{
            String[] dateArr =  album.getReleaseYear().toString().split("-");
            int releaseYear = Integer.parseInt(dateArr[0]);
            if(Integer.parseInt(date)==releaseYear)albumsInTheYear.add(album);
        });
        return albumsInTheYear;

    }

    @Override
    public void deleteAlbumById(long id) {
        albumManagerRepository.deleteById(id);
    }

}
