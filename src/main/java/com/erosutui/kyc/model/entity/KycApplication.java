package com.erosutui.kyc.model.entity;

import com.erosutui.kyc.model.enums.DocumentType;
import com.erosutui.kyc.model.enums.KycStatus;
import com.erosutui.kyc.model.enums.VerificationResult;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Entity representing a KYC (Know Your Customer) application in the database.
 *
 * @author Eros Derique Utui
 * @since 0.0.1-SNAPSHOT
 */
@Entity
@Table(name = "kyc_applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KycApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String  userId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String dateOfBirth;

    @Column(nullable = false, unique = true)
    private String documentNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DocumentType documentType;

    private String nationality;

    private String phoneNumber;

    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private KycStatus status;

    @Enumerated(EnumType.STRING)
    private VerificationResult verificationResult;

    private Double confidenceScore;

    private Integer attemptCount = 0;

    private String rejectionReason;

    private String reviewedBy;

    private LocalDateTime reviewedAt;

    @OneToMany(
            mappedBy = "kycApplication", cascade = CascadeType.ALL, orphanRemoval = true
    )
    @Builder.Default
    private List<Document> documents = new ArrayList<>();

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    private LocalDateTime updatedAt;

    public void addDocument(Document document) {
        documents.add(document);
        document.setKycApplication(this);
    }

}
