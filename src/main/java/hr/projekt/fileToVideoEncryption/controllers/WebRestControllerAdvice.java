package hr.projekt.fileToVideoEncryption.controllers;

import hr.projekt.fileToVideoEncryption.enums.StatusCode;
import hr.projekt.fileToVideoEncryption.exceptions.FileEncryptionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WebRestControllerAdvice {

    @ExceptionHandler(FileEncryptionException.class)
    public ResponseEntity<String> handleFileEncryptionException(FileEncryptionException ex) {
        String errorMessage = "Invalid file password";
        StatusCode statusCode = ex.getStatusCode();

        HttpStatus httpStatus;

        switch (statusCode) {
            case FILE_DECRYPTION_ERROR, FILE_ENCRYPTION_ERROR:
                httpStatus = HttpStatus.UNAUTHORIZED;
                break;
            default:
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
        }

        return ResponseEntity.status(httpStatus).body(errorMessage);
    }

}
