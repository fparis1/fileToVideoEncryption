package hr.projekt.fileToVideoEncryption.exceptions;

import hr.projekt.fileToVideoEncryption.enums.StatusCode;
import lombok.Getter;

@Getter
public class FileManipulationException extends RuntimeException{
    private final StatusCode statusCode;
    private final String debugMessage;

    public FileManipulationException(StatusCode statusCode, String debugMessage) {
        this.statusCode = statusCode;
        this.debugMessage = debugMessage;
    }
}
