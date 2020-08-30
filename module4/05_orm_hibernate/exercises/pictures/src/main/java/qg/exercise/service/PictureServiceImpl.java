package qg.exercise.service;

import qg.exercise.model.Picture;
import qg.exercise.repository.PictureRepository;
import qg.exercise.repository.PictureRepositoryImpl;

import java.util.List;

public class PictureServiceImpl implements PictureService {
    private PictureRepository pictureRepository= new PictureRepositoryImpl();
    @Override
    public List<Picture> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public Picture findOne(Long id) {
        return pictureRepository.findOne(id);
    }

    @Override
    public Picture save(Picture picture) {
        return pictureRepository.save(picture);
    }
}
