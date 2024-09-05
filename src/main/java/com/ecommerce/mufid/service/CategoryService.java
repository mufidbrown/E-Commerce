package com.ecommerce.mufid.service;

import com.ecommerce.mufid.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
        CategoryDTO getCategoryById(Long id);
        List<CategoryDTO> getAllCategories();
        CategoryDTO createCategory(CategoryDTO categoryDTO);
        void deleteCategory(Long id);

}
