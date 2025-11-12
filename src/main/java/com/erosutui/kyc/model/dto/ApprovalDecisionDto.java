package com.erosutui.kyc.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApprovalDecisionDto {

    @NotBlank
    private String applicationId;

    @NotBlank
    private String decision; // APPROVE or REJECT

    private String comments;

    @NotBlank
    private String reviewerName;
}
