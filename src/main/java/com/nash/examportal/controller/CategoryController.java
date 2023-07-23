package com.nash.examportal.controller;

import com.nash.examportal.model.Category;
import com.nash.examportal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody Category category){
        Category category1 = this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateCategory(@RequestBody Category category){
        Category category1 = this.categoryService.updateCategory(category);
        return ResponseEntity.ok(category1);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllCategory(){
        return ResponseEntity.ok(this.categoryService.getAllCategory());
    }

    @GetMapping("/{cId}")
    public ResponseEntity<?> getCategory(@PathVariable Long cId){
        return ResponseEntity.ok(this.categoryService.getCategory(cId));
    }

    @DeleteMapping("/{cId}")
    public void deleteCategory(@PathVariable Long cId){
        this.categoryService.deleteCategory(cId);
    }
}
