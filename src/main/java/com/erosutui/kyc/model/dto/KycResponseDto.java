package com.erosutui.kyc.model.dto;

import com.erosutui.kyc.model.enums.KycStatus;
import com.erosutui.kyc.model.enums.VerificationResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Data Transfer Object (DTO) used for responding with KYC application details.
 *
 * @Author: Eros Derique Utui
 * @Since: 0.0.1-SNAPSHOT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KycResponseDto {

    private String applicationId;
    private String userId;
    private String firstName;
    private String lastName;
    private KycStatus status;
    private VerificationResult verificationResult;
    private Double confidenceScore;
    private String rejectionReason;
    private Integer attemptCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<DocumentDto> documents;
}
