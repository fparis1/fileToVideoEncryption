package hr.projekt.fileToVideoEncryption.controllers;

import hr.projekt.fileToVideoEncryption.constants.PathParamConstants;
import hr.projekt.fileToVideoEncryption.managers.FileConversionManager;
import hr.projekt.fileToVideoEncryption.managers.FileConversionManagerImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Log4j2
@Validated
public class FileInputController {

    @Autowired
    private FileConversionManager fileConversionManager;

    @PostMapping(path = PathParamConstants.UPLOAD_FILE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("password") String password, @RequestParam("name") String name) throws IOException {
        log.info("uploadFile endpoint entered");
        // Process the uploaded file here and convert it to an mp4 video

        String videoName = fileConversionManager.convertFileToSignedVideo(file, password, name);


        return ResponseEntity.ok(videoName);
    }

}
