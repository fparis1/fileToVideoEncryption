package hr.projekt.fileToVideoEncryption.services;

import java.awt.image.BufferedImage;
import java.util.List;

public interface VideoCreatingService {

    String imageListToVideo(List<BufferedImage> imageList, String videoName);

}
