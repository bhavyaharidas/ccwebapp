package com.neu.csye6225.webApplication.service;

import com.neu.csye6225.webApplication.entity.Images;
import com.neu.csye6225.webApplication.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ImagesService {
    @Autowired
    private ImageRepository imageRepository;

    @Transactional
    public List<Images> getImages() {
        return imageRepository.findAll();
    }

    @Transactional
    public Optional<Images> getImage(Long bookId, Long id) {
        return imageRepository.findByBookIdAndId(bookId,id);
    }

    public Images saveImage(Images images) {
        return imageRepository.save(images);
    }

    public void deleteImagess(Long id) {
        imageRepository.deleteById(id);
    }

    public void update(Images images) {
        imageRepository.save(images);
    }
}