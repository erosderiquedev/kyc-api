package com.erosutui.kyc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentUploadResponse {

    private String documentId;
    private String fileName;
    private Long fileSize;
    private String message;
    private Boolean ocrProcessed;
    private Boolean faceDetected;
}
