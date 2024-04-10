package hr.projekt.fileToVideoEncryption.services;

import hr.projekt.fileToVideoEncryption.constants.VideoConstants;
import hr.projekt.fileToVideoEncryption.enums.StatusCode;
import hr.projekt.fileToVideoEncryption.exceptions.FileManipulationException;
import hr.projekt.fileToVideoEncryption.exceptions.ImageConversionException;
import hr.projekt.fileToVideoEncryption.exceptions.VideoConversionException;
import hr.projekt.fileToVideoEncryption.utils.VideoUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Log4j2
@Service
public class VideoCreatingServiceImpl implements VideoCreatingService{
    @Override
    public File imageListToVideo(List<BufferedImage> imageList, String videoName) {

        log.info("\t \t Converting encrypted buffered images to video..");

        try {
            VideoUtil.imagesToVideo(imageList, videoName + VideoConstants.VIDEO_FORMAT);
        } catch (Exception e) {
            throw new ImageConversionException(StatusCode.IMAGE_CONVERSION_ERROR,e.getMessage());
        }


        log.info("\t \t Converting video to file..");


        //        FileContent mediaContent = new FileContent(VideoConstants.MIME_TYPE, file);
        return new File(VideoConstants.TMP_STORAGE + videoName + VideoConstants.VIDEO_FORMAT);
    }

    @Override
    public List<BufferedImage> videoToImageList(MultipartFile video) {
        // Read the bytes from the video
        byte[] videoBytes;
        try {
            videoBytes = video.getBytes();
        } catch (IOException e) {
            throw new FileManipulationException(StatusCode.ERROR_WHILE_READING_FILE, "Error while reading bytes from video");
        }

        // Convert the video bytes to images
        List<BufferedImage> imageList;
        try {
            imageList = VideoUtil.videoBytesToImages(videoBytes);
        } catch (Exception e) {
            throw new VideoConversionException(StatusCode.VIDEO_CONVERSION_ERROR, e.getMessage());
        }

        return imageList;
    }
}
