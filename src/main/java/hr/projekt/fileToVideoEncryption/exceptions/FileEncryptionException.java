package hr.projekt.fileToVideoEncryption.exceptions;

import hr.projekt.fileToVideoEncryption.enums.StatusCode;
import lombok.Getter;

@Getter
public class FileEncryptionException extends RuntimeException{
    private final StatusCode statusCode;
    private final String debugMessage;

    public FileEncryptionException(StatusCode statusCode, String debugMessage) {
        this.statusCode = statusCode;
        this.debugMessage = debugMessage;
    }
}
