package com.nash.examportal.service;

import com.nash.examportal.model.Category;

import java.util.List;

public interface CategoryService {

    public Category addCategory(Category category);

    public Category updateCategory(Category category);

    public List<Category> getAllCategory();

    public Category getCategory(Long cId);

    public void deleteCategory(Long cId);
}
