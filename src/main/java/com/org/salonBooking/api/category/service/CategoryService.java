package com.org.salonBooking.api.category.service;

import com.org.salonBooking.api.category.dto.CategoryDto;
import com.org.salonBooking.api.category.dto.CategoryRequestDto;
import com.org.salonBooking.api.category.entity.Category;
import com.org.salonBooking.api.user.entity.User;
import com.org.salonBooking.common.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService extends BaseService<Category, Long>{
    CategoryDto getCategoryById(Long id);
    Page<CategoryDto> getAllCategories(Pageable pageable);
    CategoryDto saveCategory(CategoryRequestDto categoryDto);
    CategoryDto updateCategory(Long id, CategoryRequestDto categoryDto);
    void deleteCategory(Long id);
}
