package com.example.appplantorabackend.mapper;
import com.example.appplantorabackend.entity.Category;
import com.example.appplantorabackend.payload.AddCategoryDTO;
import com.example.appplantorabackend.payload.CategoryDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    List<CategoryDTO> toDtolist(List<Category> all);

    CategoryDTO toDto(Category category);

    Category toLesson(AddCategoryDTO addCategoryDTO);
}

