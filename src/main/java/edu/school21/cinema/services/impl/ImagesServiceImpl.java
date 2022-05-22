package edu.school21.cinema.services.impl;

import edu.school21.cinema.exceptions.RequestProcessingException;
import edu.school21.cinema.models.Image;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.ImagesRepository;
import edu.school21.cinema.repositories.UserRepository;
import edu.school21.cinema.services.ImagesService;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

@Service
public class ImagesServiceImpl implements ImagesService {

    private  String imageStorePath;
    private  File imageStoreDir ;
    private ImagesRepository imagesRepository;
    private UserRepository userRepository;

    @Override
    public void saveImage(User user, Part payload){
        validateImage(payload);
        Image image = getImage(payload);
        image.setUserId(user.getId());

        Integer uploadedId = (Integer) imagesRepository.saveAndReturnKey(image);

        User updated = new User();
        updated.setId(user.getId());
        updated.setImageId(Long.valueOf(uploadedId));
        userRepository.update(updated);
        user.setImageId(Long.valueOf(uploadedId));

        try (FileOutputStream fos = new FileOutputStream(imageStoreDir.getPath() + File.separator + uploadedId.toString())) {
            payload.getInputStream().transferTo(fos);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RequestProcessingException("Error has occured during file uploading", 500);
        }
    }

    @Override
    public Image getImage(Long id){
        return imagesRepository.getById(id).orElseThrow(() -> new RequestProcessingException("Image not found", 404));
    }

    @Override
    public List<Image> getUserImages(User user){
        return imagesRepository.getListByField("user_id", user.getId());
    }

    // TODO сделать отдельный сервис для работы с файлами
    @Override
    public FileInputStream getImageFile(String filename){
        try {
            return  new FileInputStream(imageStoreDir.getPath() + File.separator +filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RequestProcessingException("File not found", 404);
        }
    }

    private void validateImage(Part payload){

    }



    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "image";
    }

    private Image getImage(Part payload){
        Image image = new Image();
        image.setMime(payload.getContentType());
        image.setDate(new Date());
        image.setSize(payload.getSize());
        image.setFilename(getFileName(payload));
        return image;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setImagesRepository(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }
    @Autowired
    public void setImageStorePath(@Value("${app.imagestore.path}") String imageStorePath) {
        this.imageStorePath = imageStorePath;
        this.imageStoreDir = new File(imageStorePath);
        if (!imageStoreDir.exists())
            imageStoreDir.mkdirs();
    }
}
