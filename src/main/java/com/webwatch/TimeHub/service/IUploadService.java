package com.webwatch.TimeHub.service;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {
    String handleSaveFile(MultipartFile file, String targetFolder);
}
