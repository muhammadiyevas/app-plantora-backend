package com.example.appplantorabackend.service;

import com.example.appplantorabackend.payload.AddCategoryDTO;
import com.example.appplantorabackend.payload.ApiResponse;
import com.example.appplantorabackend.payload.CategoryDTO;
import com.example.appplantorabackend.payload.EditCategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CategoryService {
    ApiResponse<List<CategoryDTO>> all();

    ApiResponse<CategoryDTO> add(AddCategoryDTO addCategoryDTO);

    ApiResponse<CategoryDTO> one(UUID id);

    ApiResponse<CategoryDTO> edit(UUID id, EditCategoryDTO editCategoryDTO);


    void delete(UUID id);
}
