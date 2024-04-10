package hr.projekt.fileToVideoEncryption.managers;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;


public interface FileConversionManager {

    /**
     * This method is used for converting and encrypting user file
     *
     * @param file input file from the user
     * @param password user's secret key which is used for encryption
     * @param name name of the file
     * @return byte[] of video that was made from file conversion
     */
    File convertFileToSignedVideo(MultipartFile file, String password, String name);

    /**
     * This method is used to convert video from Google Drive to original file
     *
     * @param videoName name of the uploaded video in storage (Google Drive)
     * @param password key used to decyrpt data
     * @return byte[] of original file
     */
    byte[] convertSignedVideoToFile(MultipartFile video, String password, String videoName);

}
