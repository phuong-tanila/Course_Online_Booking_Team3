package fa.training.backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fa.training.backend.entities.Category;
import fa.training.backend.entities.Feedback;
import fa.training.backend.exception.RecordNotFoundException;

import fa.training.backend.mapper.CategoryMapper;
import fa.training.backend.mapper.CourseMapper;
import fa.training.backend.mapper.FeedbackMapper;
import fa.training.backend.model.CategoryModel;
import fa.training.backend.model.CourseModel;
import fa.training.backend.model.FeedbackModel;
import fa.training.backend.services.FeedbackService;
import fa.training.backend.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fa.training.backend.entities.Course;
import fa.training.backend.services.CategoryService;
import fa.training.backend.services.CourseService;

import javax.websocket.server.PathParam;

@RestController
@Slf4j
@RequestMapping("courses")
public class CourseController {
	@Autowired
	public CourseService courseService;
	@Autowired
	public CategoryService categoryService;
    @Autowired
    public FeedbackService feedbackService;
    @Autowired
    UserService userService;
	@Autowired
	private CourseMapper courseMapper;
    @Autowired
    public CategoryMapper categoryMapper;
    @Autowired
    public FeedbackMapper feedbackMapper;
    /*Show tat ca course*/
    @GetMapping("/all-courses")
    public List<CourseModel> getCourses() {
        List<CourseModel> modelList = new ArrayList<>();
        List<Course> courseList = courseService.findAll();
        for (Course course : courseList) {
            CourseModel courseModel = courseMapper.toModel(course);
            modelList.add(courseModel);
        }
        return modelList;
    }
    /*Show course theo id*/
	@GetMapping("/{id}")
    public ResponseEntity<CourseModel> getCourseById(@PathVariable("id") int id)
			throws RecordNotFoundException {

        Course course = courseService.findById(id);
        CourseModel courseModel= courseMapper.toModel(course);

        return new ResponseEntity<CourseModel>(courseModel, new HttpHeaders(), HttpStatus.OK);
    }
    /*Show tat ca course phan trang sort theo id*/
    @GetMapping("/list-courses")
    public ResponseEntity<List<CourseModel>> getAllCourses(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<CourseModel> modelList = new ArrayList<>();
        ;
        List<Course> courseList = courseService.getAllCourses(pageNo, pageSize, sortBy);
        for (Course course : courseList) {
            CourseModel courseModel = courseMapper.toModel(course);
            modelList.add(courseModel);
        }
        return new ResponseEntity<List<CourseModel>>(modelList, new HttpHeaders(), HttpStatus.OK);
    }

    /*Show tat ca feedback*/
    @GetMapping("/list-feedback")
    public List<FeedbackModel> getAllFeedback() {
        List<FeedbackModel> modelList = new ArrayList<>();
        ;
        List<Feedback> feedbacks = feedbackService.findAll();
        for (Feedback feedback : feedbacks) {
            FeedbackModel feedbackModel = feedbackMapper.toModel(feedback);
            modelList.add(feedbackModel);
        }
        return modelList;
    }

    /*Show feedback sort theo rating*/
    @GetMapping("/sortFeedbackByRating")
    public List<CourseModel> sortCourseByRating() {
        List<FeedbackModel> feedbackModels= feedbackService.getAllFeedback();
        List<Course> courseList= courseService.getCourseByRaing(feedbackModels);
        List<CourseModel> modelList = new ArrayList<>();
        for (Course course : courseList) {
            CourseModel courseModel = courseMapper.toModel(course);
            modelList.add(courseModel);
        }
        return modelList;
    }

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
    /*Show course theo course name*/
//    @GetMapping("/get-course-by-name/{courseName}")
//    public ResponseEntity<List<CourseModel>> getCourseByName(
//            @RequestParam(defaultValue = "0") Integer pageNo,
//            @RequestParam(defaultValue = "5") Integer pageSize,
//            @RequestParam(defaultValue = "id") String[] sortBy,
//            @RequestParam(defaultValue = "desc") String[] diretions,
//            @RequestParam(defaultValue = "{courseName}") String courseName
//    )throws RecordNotFoundException{
//        if(sortBy.length != diretions.length)
//        {
//            return new ResponseEntity("the length of sortBy and diretions are not identical", new HttpHeaders(), HttpStatus.NOT_FOUND);
//        }
//        HashMap<String, String> orderHashMap = new HashMap<>();
//        for (int i = 0; i < sortBy.length; i++) {
//            String currentProperty = sortBy[i];
//            String currentDirection = diretions[i];
//            orderHashMap.put(currentProperty, currentDirection);
//        }
//        List<Course> list = courseService.findByCourseName(pageNo, pageSize, orderHashMap, courseName);
//        List<CourseModel> results = new ArrayList<>();
//        list.forEach(course -> results.add(courseMapper.toModel(course)));
//        return new ResponseEntity<List<CourseModel>>(results, new HttpHeaders(), HttpStatus.OK);
//    }





}