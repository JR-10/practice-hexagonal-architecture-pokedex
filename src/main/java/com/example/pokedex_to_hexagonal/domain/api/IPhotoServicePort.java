package com.example.pokedex_to_hexagonal.domain.api;

import com.example.pokedex_to_hexagonal.domain.model.Photo;

import java.util.List;

public interface IPhotoServicePort {

    Photo savePhoto(Photo photo);

    List<Photo> getAllPhotos();

    Photo getPhotoByPhotoId(String photoId);

    void updatePhoto(Photo photo);

    void deletePhoto(String photoId);

}
