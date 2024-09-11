package com.northcoders.example.RecordShop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.example.RecordShop.model.Album;
import com.northcoders.example.RecordShop.service.AlbumManagerServiceImpl;
import jakarta.persistence.ManyToOne;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import  static org.mockito.Mockito.times;
import  static org.mockito.Mockito.verify;
import  static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AutoConfigureMockMvc
@SpringBootTest
class AlbumManagerControllerTest {
    @Mock
    private AlbumManagerServiceImpl mockAlbumManagerServiceImpl;

    @InjectMocks
    private AlbumManagerController albumManagerController;

    @Autowired
    private MockMvc mockMvcController;
    private ObjectMapper mapper;

    @BeforeEach
    public void setup(){
        mockMvcController = MockMvcBuilders.standaloneSetup(albumManagerController).build();
        mapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Get all album that exist")
    void getAll() throws Exception {
        List<Album> albumList= new ArrayList<>();
        albumList.add(new Album(1,"Midnight","Taylor","pop",LocalDate.now()));
        albumList.add(new Album(2,"Midnight","Taylor","pop",LocalDate.now()));
        albumList.add(new Album(3,"Midnight","Taylor","pop",LocalDate.now()));

        int albumListSize = albumList.size();

        //this is mocking controller getAll method and it returns albumList
        when(albumManagerController.getAllAlbums()).thenReturn(albumList);

        //this is mocking http webserver request to the endpoint
        this.mockMvcController.perform(MockMvcRequestBuilders.get("/api/album"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Midnight"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].artist").value("Taylor"));
    }


    @Test
    @DisplayName("Get one album by id")
    void getAlbumById() throws Exception {
        Album testAlbum = new Album(1,"Midnight","Taylor", "pop", LocalDate.now());


        //this is mocking controller getAll method and it returns albumList from fake repo interaction
        when(albumManagerController.getAlbumById(1)).thenReturn( testAlbum);

        //this is mocking http webserver request to the endpoint
        this.mockMvcController.perform(MockMvcRequestBuilders.get("/api/album/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Midnight"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.artist").value("Taylor"));
    }




//    @Test
//    void saveAlbum() throws Exception {
//        Album testAlbum = new Album(1,"Midnight","Taylor", "pop", LocalDate.now());
//
//            given(albumManagerController.saveAlbum(ArgumentMatchers.any())).willAnswer((invocation -> invocation.getArgument(0)));
//
//            ResultActions response = mockMvcController.perform(post("/api/album")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(mapper.writeValueAsString(testAlbum)));
//
//            response.andExpect(MockMvcResultMatchers.status().isCreated());
//
//
//        }

}