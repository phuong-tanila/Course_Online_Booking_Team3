package fa.training.backend.controller;

import fa.training.backend.entities.Category;
import fa.training.backend.mapper.CategoryMapper;
import fa.training.backend.model.CategoryModel;
import fa.training.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryMapper categoryMapper;
    /*Show tat ca category*/
    @GetMapping("/list-category")
    public List<CategoryModel> getAllCategory() {
        List<CategoryModel> modelList = new ArrayList<>();
        List<Category> categories = categoryService.getAllCategory();
        for (Category category : categories) {
            CategoryModel categoryModel = categoryMapper.toModel(category);
            modelList.add(categoryModel);
        }
        return modelList;
    }
    /*Show Course theo categoryName*/
    @RequestMapping("/category-by-name")
    public ResponseEntity<List<CategoryModel>> getAllCategoryByName(String categoryName){
        List<CategoryModel> results = new ArrayList<>();
        List<Category> list = categoryService.getCategoryCategoryName(categoryName);
        list.forEach(Category -> results.add(categoryMapper.toModel(Category)));
        return new ResponseEntity<List<CategoryModel>>(results, new HttpHeaders(), HttpStatus.OK);
    }
}
