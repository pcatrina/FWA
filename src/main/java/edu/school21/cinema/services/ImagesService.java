package edu.school21.cinema.services;

import edu.school21.cinema.models.Image;
import edu.school21.cinema.models.User;
import jakarta.servlet.http.Part;

import java.io.FileInputStream;
import java.util.List;

public interface ImagesService {
    void saveImage(User user, Part payload);

    Image getImage(Long id);

    List<Image> getUserImages(User user);

    // TODO сделать отдельный сервис для работы с файлами
    FileInputStream getImageFile(String filename);
}
