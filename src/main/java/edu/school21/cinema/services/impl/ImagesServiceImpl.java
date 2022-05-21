package edu.school21.cinema.services.impl;

import edu.school21.cinema.repositories.ImagesRepository;
import edu.school21.cinema.services.ImagesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImagesServiceImpl implements ImagesService {
    private ImagesRepository imagesRepository;
}
