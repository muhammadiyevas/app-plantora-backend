package com.example.appplantorabackend.controller;

import com.example.appplantorabackend.payload.AddCategoryDTO;
import com.example.appplantorabackend.payload.ApiResponse;
import com.example.appplantorabackend.payload.CategoryDTO;
import com.example.appplantorabackend.payload.EditCategoryDTO;
import com.example.appplantorabackend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
@RestController
@RequiredArgsConstructor
public class CategoryControllerImpl implements CategoryController {

    private final CategoryService categoryService;
    @Override
    public HttpEntity<ApiResponse<List<CategoryDTO>>> all() {
        return ResponseEntity.ok(categoryService.all());
    }

    @Override
    public HttpEntity<ApiResponse<CategoryDTO>> add(AddCategoryDTO addCategoryDTO) {
        return ResponseEntity.ok(categoryService.add(addCategoryDTO));
    }

    @Override
    public HttpEntity<ApiResponse<CategoryDTO>> one(UUID id) {
        return ResponseEntity.ok(categoryService.one(id));
    }

    @Override
    public HttpEntity<ApiResponse<CategoryDTO>> edit(UUID id, EditCategoryDTO editCategoryDTO) {
        return ResponseEntity.ok(categoryService.edit(id,editCategoryDTO));
    }

    @Override
    public HttpEntity<ApiResponse<?>> delete(UUID id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
