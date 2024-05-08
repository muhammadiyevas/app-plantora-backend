package com.example.appplantorabackend.service;

import com.example.appplantorabackend.entity.Category;
import com.example.appplantorabackend.exception.MyConflictException;
import com.example.appplantorabackend.exception.MyNotFoundException;
import com.example.appplantorabackend.mapper.CategoryMapper;
import com.example.appplantorabackend.payload.AddCategoryDTO;
import com.example.appplantorabackend.payload.ApiResponse;
import com.example.appplantorabackend.payload.CategoryDTO;
import com.example.appplantorabackend.payload.EditCategoryDTO;
import com.example.appplantorabackend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;
    @Override
    public ApiResponse<List<CategoryDTO>> all() {
        return ApiResponse.success(categoryMapper.toDtolist(categoryRepository.findAll()));
    }

    @Override
    public ApiResponse<CategoryDTO> add(AddCategoryDTO addCategoryDTO) {
        if (categoryRepository.existsByNameAndModuleId(addCategoryDTO.name(),addCategoryDTO.attachmentId()))
            throw new MyConflictException("Category already exists!");

        return ApiResponse.success(categoryMapper.toDto(categoryRepository.save(categoryMapper.toLesson(addCategoryDTO))));
    }

    @Override
    public ApiResponse<CategoryDTO> one(UUID id) {
        return ApiResponse.success(categoryMapper.toDto(
                categoryRepository.findById(id).orElseThrow(() ->
                        new MyNotFoundException("Category not found by id"))));
    }

    @Override
    public ApiResponse<CategoryDTO> edit(UUID id, EditCategoryDTO editCategoryDTO) {
        Category editCategory = categoryRepository.findById(id).orElseThrow(() -> new MyNotFoundException("Category not found by id"));

        if (categoryRepository.existsByNameAndModuleIdAndIdNot(editCategory.getName(),editCategory.getPhoto(), id))
            throw new MyConflictException("Lesson already exists!");

        editCategory.setName(editCategory.getName());

        return ApiResponse.success(categoryMapper.toDto(categoryRepository.save(editCategory)));
    }

    @Override
    public void delete(UUID id) {
        if (!categoryRepository.existsById(id))
            throw new MyNotFoundException("Role not found by id!");

        categoryRepository.deleteById(id);
    }
}
