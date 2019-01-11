package com.kovalenko.binding;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
public class UploadDocument {

    @NotNull
    private MultipartFile file;
    @NotBlank
    private String description;
}
