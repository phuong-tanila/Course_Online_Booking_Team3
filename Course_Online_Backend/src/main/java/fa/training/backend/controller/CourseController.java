package fa.training.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import fa.training.backend.entities.Course;
import fa.training.backend.exception.RecordNotFoundException;
import fa.training.backend.mapper.MapStructConverter;
import fa.training.backend.model.CourseModel;
import fa.training.backend.services.CategoryService;
import fa.training.backend.services.CourseService;

@RestController
//@RequestMapping(path="/JSON", produces="application/json")
public class CourseController {

	@Autowired
	public CourseService courseService;
	@Autowired
	public CategoryService categoryService
	@GetMapping("/courses")
	public List<CourseModel> getCourseBy() 
	{
		List<CourseModel> modelList = new ArrayList<>();;
		List<Course> courseList= courseService.findAll();
		for(Course course : courseList) {
			CourseModel courseModel = mapStructConverter.sourceToDestination(course);
			modelList.add(courseModel);
		}
		return modelList;
	}
	
//	@GetMapping("/courses/{id}")
//    public ResponseEntity<Course> getCourseById(@PathVariable("id") int id)
//                                                    throws RecordNotFoundException {
//        Course course = courseService.findById(id);
// 
//        return new ResponseEntity<Course>(course, new HttpHeaders(), HttpStatus.OK);
//    }
// 
//	@GetMapping("/courses")
//    public ResponseEntity<List<Course>> getAllCourses(
//                        @RequestParam(defaultValue = "0") Integer pageNo,
//                        @RequestParam(defaultValue = "5") Integer pageSize,
//                        @RequestParam(defaultValue = "id") String sortBy)
//    {
//        List<Course> listCourses = courseService.getAllCourses(pageNo, pageSize, sortBy);
//
//        return new ResponseEntity<List<Course>>(listCourses, new HttpHeaders(), HttpStatus.OK);
//    }
//	@GetMapping("/courses/sortbyrating")
//    public ResponseEntity<List<Course>> sortByRating(
//                        @RequestParam(defaultValue = "0") Integer pageNo,
//                        @RequestParam(defaultValue = "5") Integer pageSize,
//                        @RequestParam(defaultValue = "rating") String sortBy)
//    {
//        List<Course> listCourses = courseService.sortCoursesByRating(pageNo, pageSize, sortBy);
//
//        return new ResponseEntity<List<Course>>(listCourses, new HttpHeaders(), HttpStatus.OK);
//    }
	
	
//	@GetMapping(value = "/category/{categoryName}")
//    public List<Course> getCourseByCategory(String categoryName, Pageable pageable){
//		Category category= categoryService.getCategoryByName(categoryName);
//		List<Course> list= courseService.getCourseByCategoryName(category, pageable);
//     return  list;
//    }
//	@GetMapping(value = "/category/{categoryName}")
//	public List<Course> getCourseByCategory(String categoryName){
//		Category category= categoryService.getCategoryByName(categoryName);
//		List<Course> list= courseService.findCourseByCategoryName(category);
//		return list;
//		
//	}
	
	
	

}