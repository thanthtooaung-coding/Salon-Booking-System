package com.org.salonBooking.api.category.service.impl;

import com.org.salonBooking.api.category.dto.CategoryDto;
import com.org.salonBooking.api.category.dto.CategoryRequestDto;
import com.org.salonBooking.api.category.entity.Category;
import com.org.salonBooking.api.category.repository.CategoryRepository;
import com.org.salonBooking.api.category.service.CategoryService;
import com.org.salonBooking.api.user.dto.UserDto;
import com.org.salonBooking.api.user.entity.User;
import com.org.salonBooking.api.user.service.UserService;
import com.org.salonBooking.common.service.impl.BaseServiceImpl;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImplement extends BaseServiceImpl<Category, Long> implements CategoryService {

    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    @Override
    protected JpaRepository<Category, Long> getRepository() { return categoryRepository; }

    @Override
    protected String getEntityName() { return "Category"; }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = findById(id);
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public Page<CategoryDto> getAllCategories(Pageable pageable) {
        return findAll(pageable).map((category) -> modelMapper.map(category, CategoryDto.class));
    }

    @Override
    public CategoryDto saveCategory(CategoryRequestDto categoryDto) {

        if(categoryRepository.existsByName(categoryDto.getName())) {
            throw new DataIntegrityViolationException("Category name already exists");
        }

        Category category = modelMapper.map(categoryDto, Category.class);
        Category savedCategory = create(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryRequestDto categoryDto) {
        Category category = findById(id);
        String categoryNameFromDto = categoryDto.getName();

        if (category.getName().equals(categoryNameFromDto) && categoryRepository.existsByName(categoryNameFromDto)) {
            throw new DataIntegrityViolationException("Category name already exists");
        }

        Optional.ofNullable(categoryDto.getName())
                .filter(name -> !name.isEmpty())
                .ifPresent(category::setName);

        Category updatedCategory = update(id, category);
        return modelMapper.map(updatedCategory, CategoryDto.class);


    }
    @Override
    public void deleteCategory(Long id) { delete(id); }
}
