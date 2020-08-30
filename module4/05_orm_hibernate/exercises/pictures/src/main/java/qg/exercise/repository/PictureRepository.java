package qg.exercise.repository;

import qg.exercise.model.Picture;
import java.util.List;

public interface PictureRepository {
    List<Picture> findAll();

    Picture findOne(Long id);

    Picture save(Picture picture);
}
