package com.kovalenko.entity.document;

import com.kovalenko.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Document {

    private long id;
    @NotBlank
    private String title;
    private LocalDateTime created;
    private User author;
}
