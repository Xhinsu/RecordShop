package com.northcoders.example.RecordShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long genreId;
    private String name;
    //many genre belongs to one album
    @ManyToOne
    @JoinTable(name="album_Id",
    joinColumns = @JoinColumn(name = "genreId"),
    inverseJoinColumns = @JoinColumn(name="album_Id")
    )
    private Album album;

}
