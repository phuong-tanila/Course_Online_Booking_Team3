package fa.training.backend.controller;

import fa.training.backend.entities.Category;
import fa.training.backend.entities.Course;
import fa.training.backend.exception.RecordNotFoundException;
import fa.training.backend.mapper.CategoryMapper;
import fa.training.backend.mapper.FeedbackMapper;
import fa.training.backend.model.CategoryModels.CategoryModelDetail;
import fa.training.backend.model.CourseModel;
import fa.training.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    public CategoryService categoryService;
    @Autowired
    public CategoryMapper categoryMapper;

    //api for history
    @GetMapping("/{id}")
    ResponseEntity<CategoryModelDetail> getCourseById(@PathVariable("id") int id) throws RecordNotFoundException {
        Optional category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            CategoryModelDetail categoryModelDetail = categoryMapper.toModelDetail((Category) category.get());
            return new ResponseEntity<CategoryModelDetail>(categoryModelDetail, new HttpHeaders(), HttpStatus.OK);
        } else return new ResponseEntity<CategoryModelDetail>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
