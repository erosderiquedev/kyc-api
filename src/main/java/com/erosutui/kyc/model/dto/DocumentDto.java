package com.erosutui.kyc.model.dto;

import com.erosutui.kyc.model.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentDto {

    private String id;
    private DocumentType documentType;
    private String originalFileName;
    private Long fileSize;
    private Boolean ocrProcessed;
    private Boolean faceDetected;
    private Double faceMatchScore;
    private LocalDateTime uploadedAt;
}

