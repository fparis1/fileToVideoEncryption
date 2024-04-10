package hr.projekt.fileToVideoEncryption.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {

    NO_ERROR(0),
    GOOGLE_DRIVE_VIDEO_DOWNLOAD_ERROR(100),
    GOOGLE_DRIVE_INITIALIZATION_ERROR(101),
    IMAGE_CONVERSION_ERROR(102),
    FILE_DELETION_ERROR(103),
    FILE_ENCRYPTION_ERROR(104),
    FILE_DECRYPTION_ERROR(105),
    HTTP_TRANSPORT_ERROR(106),
    VIDEO_CONVERSION_ERROR(107),
    DRIVE_CREDENTIALS_ERROR(108),
    GOOGLE_DRIVE_UPLOAD_ERROR(109),
    ERROR_WHILE_SAVING_FILE(110),
    ERROR_WHILE_READING_FILE(111),
    GOOGLE_DRIVE_DELETE_ERROR(112);

    private final int code;
}