package com.example.appplantorabackend.repository;

import com.example.appplantorabackend.entity.Attachment;
import com.example.appplantorabackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    boolean existsByNameAndModuleId(String name, UUID uuid);

    boolean existsByNameAndModuleIdAndIdNot(String name, Attachment photo, UUID id);
}
