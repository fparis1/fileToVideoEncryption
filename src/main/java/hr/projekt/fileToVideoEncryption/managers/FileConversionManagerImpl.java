package hr.projekt.fileToVideoEncryption.managers;

import hr.projekt.fileToVideoEncryption.services.FileConversionService;
import hr.projekt.fileToVideoEncryption.services.VideoCreatingService;
import javafx.util.Pair;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class FileConversionManagerImpl implements FileConversionManager {


    private final FileConversionService fileConversionService;
    private final VideoCreatingService videoCreatingService;

    @Autowired
    public FileConversionManagerImpl(FileConversionService fileConversionService, VideoCreatingService videoCreatingService) {
        this.fileConversionService = fileConversionService;
        this.videoCreatingService = videoCreatingService;
    }


    @Override
    public File convertFileToSignedVideo(MultipartFile file, String password, String name) {
        log.info("Conversion of file to signed video.");

        log.info("\t 1.Converting and encrypting file to binary images..");
        Pair<List<BufferedImage>, String> imagesAndName = fileConversionService.convertFileToImageList(file, password, name);

        log.info("\t 2. Converting images to video");
        File videoFile = videoCreatingService.imageListToVideo(imagesAndName.getKey(), imagesAndName.getValue());

        log.info("\t    Conversion finished!");

        return videoFile;
    }

    @Override
    public byte[] convertSignedVideoToFile(MultipartFile video, String password, String videoName) {
        log.info("Getting file from signed video.");
        List<BufferedImage> imageList = videoCreatingService.videoToImageList(video);
        log.info("\t 2. Decrypting images and converting them to a file..");
        byte[] fileContent = fileConversionService.convertImageListToFile(imageList, password, videoName);

        log.info("\t    Retrieving file finished!");


        return fileContent;
    }
}
