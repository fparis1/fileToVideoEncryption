package hr.projekt.fileToVideoEncryption.exceptions;

import hr.projekt.fileToVideoEncryption.enums.StatusCode;
import lombok.Getter;

@Getter
public class ImageConversionException extends RuntimeException{
    private final StatusCode statusCode;
    private final String debugMessage;

    public ImageConversionException(StatusCode statusCode, String debugMessage) {
        this.statusCode = statusCode;
        this.debugMessage = debugMessage;
    }
}
