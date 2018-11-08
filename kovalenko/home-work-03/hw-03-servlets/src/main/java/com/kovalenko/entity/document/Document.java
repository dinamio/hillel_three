package com.kovalenko.entity.document;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Document {

    private long id;
    private String title;
    private LocalDateTime created;
}
