package qg.exercise.service;

import qg.exercise.model.Picture;

import java.util.List;

public interface PictureService {
    List<Picture> findAll();

    Picture findOne(Long id);

    Picture save(Picture picture);
}
