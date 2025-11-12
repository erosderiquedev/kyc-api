package com.erosutui.kyc.model.dto;

import com.erosutui.kyc.model.enums.DocumentType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


/**
 * Data Transfer Object (DTO) used for submitting a KYC application request.
 *
 * @Author: Eros Derique Utui
 * @Since: 0.0.1-SNAPSHOT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KycRequestDto {

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50)
    private String lastName;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Document number is required")
    private String documentNumber;

    @NotNull(message = "Document type is required")
    private DocumentType documentType;

    @NotBlank(message = "Nationality is required")
    private String nationality;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^(?:\\+258|00258)?[28]\\d{8}$\n", message = "Invalid phone number")
    private String phoneNumber;

    @NotBlank(message = "Address is required")
    private String address;
}
