CREATE TABLE documents
(
    id                 VARCHAR(255) NOT NULL,
    kyc_application_id UUID         NOT NULL,
    document_type      VARCHAR(255) NOT NULL,
    original_file_name VARCHAR(255) NOT NULL,
    storage_path       VARCHAR(255) NOT NULL,
    content_type       VARCHAR(255) NOT NULL,
    file_size          BIGINT       NOT NULL,
    ocr_text           VARCHAR(255),
    ocr_processed      BOOLEAN,
    face_detected      BOOLEAN,
    face_match_score   DOUBLE PRECISION,
    uploaded_at        TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_documents PRIMARY KEY (id)
);

CREATE TABLE kyc_applications
(
    id                  UUID         NOT NULL,
    user_id             VARCHAR(255) NOT NULL,
    first_name          VARCHAR(255) NOT NULL,
    last_name           VARCHAR(255) NOT NULL,
    date_of_birth       VARCHAR(255) NOT NULL,
    document_number     VARCHAR(255) NOT NULL,
    document_type       VARCHAR(255) NOT NULL,
    nationality         VARCHAR(255),
    phone_number        VARCHAR(255),
    address             VARCHAR(255),
    status              VARCHAR(255) NOT NULL,
    verification_result VARCHAR(255),
    confidence_score    DOUBLE PRECISION,
    attempt_count       INTEGER,
    rejection_reason    VARCHAR(255),
    reviewed_by         VARCHAR(255),
    reviewed_at         TIMESTAMP WITHOUT TIME ZONE,
    created_at          TIMESTAMP WITHOUT TIME ZONE,
    updated_at          TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_kyc_applications PRIMARY KEY (id)
);

ALTER TABLE kyc_applications
    ADD CONSTRAINT uc_kyc_applications_documentnumber UNIQUE (document_number);

ALTER TABLE documents
    ADD CONSTRAINT FK_DOCUMENTS_ON_KYC_APPLICATION FOREIGN KEY (kyc_application_id) REFERENCES kyc_applications (id);