package com.example.book.shared.model;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.book.shared.api.UploadFileResponse;
import com.example.book.shared.services.FileStorageService;

public class FileUtils {
    public static UploadFileResponse doUploadFile(FileStorageService fileStorageService, String id, final MultipartFile file) throws Exception {
        if(fileStorageService == null || id == null || file == null) {
            throw new Exception("Could not get reference of fileStorageService, id or file");
        }

        final String fileName = fileStorageService.storeFile(id, file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentRequestUri().pathSegment(fileName)
                .toUriString();
        // since we are reusing this method both for single file upload and multiple
        // file upload and have different urls we need to make sure we always return the
        // right url for the single file download
        fileDownloadUri = fileDownloadUri.replace("/photos/", "/photo/");

        // TODO save info of the file on the database

        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }
}
