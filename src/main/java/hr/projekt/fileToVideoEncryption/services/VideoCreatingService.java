package hr.projekt.fileToVideoEncryption.services;

import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public interface VideoCreatingService {

    File imageListToVideo(List<BufferedImage> imageList, String videoName);

    List<BufferedImage> videoToImageList(MultipartFile video);

}
