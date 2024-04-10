package hr.projekt.fileToVideoEncryption.controllers;

import hr.projekt.fileToVideoEncryption.constants.PathParamConstants;
import hr.projekt.fileToVideoEncryption.managers.FileConversionManager;
import hr.projekt.fileToVideoEncryption.managers.FileConversionManagerImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@Log4j2
@Validated
public class FileInputController {

    @Autowired
    private FileConversionManager fileConversionManager;

    @PostMapping(path = PathParamConstants.UPLOAD_FILE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<Resource> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("password") String password, @RequestParam("name") String name) throws IOException {
        log.info("uploadFile endpoint entered");
        // Process the uploaded file here and convert it to an mp4 video

        File videoFile = fileConversionManager.convertFileToSignedVideo(file, password, name);

        // Prepare a resource pointing to the video file
        Path path = Paths.get(videoFile.getAbsolutePath());
        InputStreamResource resource = new InputStreamResource(Files.newInputStream(path));

        // Prepare and return the response
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("video/mp4"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + videoFile.getName() + "\"")
                .body(resource);
    }

}
