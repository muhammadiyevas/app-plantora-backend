package com.example.appplantorabackend.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EditCategoryDTO(@NotBlank(message = "Name is required") String name,
                              @NotNull(message = "Photo is required") UUID attachmentId) {
}
