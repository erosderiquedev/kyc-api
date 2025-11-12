package com.erosutui.kyc.model.enums;

/**
 * Enum representing the status of a KYC application throughout its lifecycle.
 *
 * @Author: Eros Derique Utui
 * @Since: 0.0.1-SNAPSHOT
 */
public enum KycStatus {
    PENDING,
    DOCUMENTS_UPLOADED,
    UNDER_REVIEW,
    APPROVED,
    REJECTED,
    EXPIRED
}
