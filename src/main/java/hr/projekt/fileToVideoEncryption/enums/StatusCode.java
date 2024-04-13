package hr.projekt.fileToVideoEncryption.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {

    NO_ERROR(0),
    IMAGE_CONVERSION_ERROR(102),
    FILE_DELETION_ERROR(103),
    FILE_ENCRYPTION_ERROR(104),
    FILE_DECRYPTION_ERROR(105),
    HTTP_TRANSPORT_ERROR(106),
    VIDEO_CONVERSION_ERROR(107),
    ERROR_WHILE_SAVING_FILE(110),
    ERROR_WHILE_READING_FILE(111);

    private final int code;
}
