package com.ecommerce.mufid.entity.mapper;

import com.ecommerce.mufid.dto.CategoryDTO;
import com.ecommerce.mufid.entity.Category;

public class CategoryMapper {

    public CategoryDTO toDto(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        return dto;
    }

    public Category toEntity(CategoryDTO dto) {
        Category category = new Category();
        category.setCategoryId(dto.getCategoryId());
        category.setCategoryName(dto.getCategoryName());
        return category;
    }

}
