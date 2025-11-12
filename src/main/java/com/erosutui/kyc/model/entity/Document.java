package com.erosutui.kyc.model.entity;

import com.erosutui.kyc.model.enums.DocumentType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * Entity representing a document submitted for KYC verification in the database.
 *
 * @author Eros Derique Utui
 * @since 0.0.1-SNAPSHOT
 */
@Entity
@Table(name = "documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kyc_application_id", nullable = false)
    private KycApplication kycApplication;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DocumentType documentType;

    @Column(nullable = false)
    private String originalFileName;

    @Column(nullable = false)
    private String storagePath;

    @Column(nullable = false)
    private String contentType;

    @Column(nullable = false)
    private Long fileSize;

    private String ocrText;

    private Boolean ocrProcessed = false;

    private Boolean faceDetected;

    private Double faceMatchScore;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime uploadedAt;

}
