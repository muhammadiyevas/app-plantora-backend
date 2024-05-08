package com.example.appplantorabackend.controller;

import com.example.appplantorabackend.payload.AddCategoryDTO;
import com.example.appplantorabackend.payload.ApiResponse;
import com.example.appplantorabackend.payload.CategoryDTO;
import com.example.appplantorabackend.payload.EditCategoryDTO;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(CategoryController.CATEGORY_PATH)
public interface CategoryController {
    String CATEGORY_PATH="/api/categroy";

    @GetMapping
    HttpEntity<ApiResponse<List<CategoryDTO>>> all();

    @PostMapping
    HttpEntity<ApiResponse<CategoryDTO>> add(@RequestBody AddCategoryDTO addCategoryDTO);

    @GetMapping("/{id}")
    HttpEntity<ApiResponse<CategoryDTO>> one(@PathVariable UUID id);

    @PutMapping("/{id}")
    HttpEntity<ApiResponse<CategoryDTO>> edit(@PathVariable UUID id,
                                            @RequestBody EditCategoryDTO editCategoryDTO);

    @DeleteMapping("/{id}")
    HttpEntity<ApiResponse<?>> delete(@PathVariable UUID id);


}
