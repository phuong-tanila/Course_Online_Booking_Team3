package fa.training.backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fa.training.backend.entities.Category;
import fa.training.backend.exception.RecordNotFoundException;

import fa.training.backend.mapper.CategoryMapper;
import fa.training.backend.mapper.CourseMapper;
import fa.training.backend.mapper.FeedbackMapper;
import fa.training.backend.model.CourseModel;
import fa.training.backend.repositories.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
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
//@RequestMapping(path="/JSON", produces="application/json")
public class CourseController {

	@Autowired
	public CourseService courseService;
	@Autowired
	public CategoryService categoryService;
	@Autowired
	private CourseMapper courseMapper;
    @Autowired
    public CategoryMapper categoryMapper;
    @Autowired
    public FeedbackMapper feedbackMapper;
	@GetMapping("/{id}")
    public ResponseEntity<CourseModel> getCourseById(@PathVariable("id") int id)
			throws RecordNotFoundException {

        Course course = courseService.findById(id);
        CourseModel courseModel= courseMapper.toModel(course);

        return new ResponseEntity<CourseModel>(courseModel, new HttpHeaders(), HttpStatus.OK);
    }

//	@GetMapping("/")
//    public ResponseEntity<List<Course>> getAllCourses(
//                        @RequestParam(defaultValue = "0") Integer pageNo,
//                        @RequestParam(defaultValue = "5") Integer pageSize,
//                        @RequestParam(defaultValue = "id") String sortBy)
//    {
//        List<Course> listCourses = courseService.getAllCourses(pageNo, pageSize, sortBy);
//
//        return new ResponseEntity<List<Course>>(listCourses, new HttpHeaders(), HttpStatus.OK);
//    }

//    @GetMapping("/")
//	@GetMapping("/sortbyrating")
//    public ResponseEntity<List<Course>> sortByRating(
//                        @RequestParam(defaultValue = "0") Integer pageNo,
//                        @RequestParam(defaultValue = "5") Integer pageSize,
//                        @RequestParam(defaultValue = "rating") String sortBy)
//    {
//        List<Course> listCourses = courseService.sortCoursesByRating(pageNo, pageSize, sortBy);
//
//        return new ResponseEntity<List<Course>>(listCourses, new HttpHeaders(), HttpStatus.OK);
//    }
//

//	@GetMapping(value = "/categories")
//	public List<Course> getCourseByCategory(
//			@PathParam("categories") List<String> categoryName,
//			@PathParam("pageNo")
//	){
//		List<Category> categories = new ArrayList<>();
//		categoryName.forEach(cateName -> {
//			categories.add(categoryService.getCategoryByName(cateName));
//		});
//		List<Course> list= courseService.getCourseByCategory(categories, pageable);
//		return  list;
//	}




//	@GetMapping(value = "/categories/{categoryName}")
//	public List<Course> getCourseByCategory(String categoryName){
//		Category category= categoryService.getCategoryByName(categoryName);
//		List<Course> list= courseService.findCourseByCategory(category);
//		return list;
//	}

    /**
     * @apiNote wait for checking naming conventions
     * */
	@GetMapping("/get-course-by-name")
    public ResponseEntity<List<CourseModel>> getCourseByName(
                @RequestParam(defaultValue = "0") Integer pageNo,
                @RequestParam(defaultValue = "5") Integer pageSize,
                @RequestParam(defaultValue = "id") String[] sortBy,
                @RequestParam(defaultValue = "desc") String[] diretions,
                @RequestParam (defaultValue = "java")String courseName
            )throws RecordNotFoundException{
        if(sortBy.length != diretions.length)
        {
            return new ResponseEntity("the length of sortBy and diretions are not identical", new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
        HashMap<String, String> orderHashMap = new HashMap<>();
        for (int i = 0; i < sortBy.length; i++) {
            String currentProperty = sortBy[i];
            String currentDirection = diretions[i];
            orderHashMap.put(currentProperty, currentDirection);
        }
        List<Course> list = courseService.findByCourseName(pageNo, pageSize, orderHashMap, courseName);
		List<CourseModel> results = new ArrayList<>();
		list.forEach(course -> results.add(courseMapper.toModel(course)));
        return new ResponseEntity<List<CourseModel>>(results, new HttpHeaders(), HttpStatus.OK);
    }
	@GetMapping("/a")
    public ResponseEntity<List<CourseModel>> getCourseCustom(){
        List<Course> courses = courseService.customGetAll();
        List<CourseModel> result = new ArrayList<>();
        courses.forEach(c -> {
            result.add(courseMapper.toModel(c));
        });
        return new ResponseEntity<List<CourseModel>>(result, new HttpHeaders(), HttpStatus.OK);
    }

}