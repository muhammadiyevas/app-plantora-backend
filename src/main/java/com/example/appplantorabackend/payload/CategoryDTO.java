package com.example.appplantorabackend.payload;

import com.example.appplantorabackend.entity.Attachment;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDTO {
    UUID id;
    String name;
    Attachment attachmentDto;
}
