package fa.training.backend.controller;

import java.util.List;

import fa.training.backend.entities.Category;
import fa.training.backend.exception.RecordNotFoundException;
import fa.training.backend.mapper.implement.CourseMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

<<<<<<< HEAD
=======
import org.springframework.data.domain.Pageable;
>>>>>>> proj1/main
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fa.training.backend.entities.Course;
import fa.training.backend.services.CategoryService;
import fa.training.backend.services.CourseService;

@RestController
//@RequestMapping(path="/JSON", produces="application/json")
public class CourseController {

	@Autowired
	public CourseService courseService;
	@Autowired
	public CategoryService categoryService;
	@Autowired
<<<<<<< HEAD
	public MapStructConverter mapStructConverter;
	
	@GetMapping("/coursesAll")
	public List<CourseModel> getCourse() 
	{
		List<CourseModel> modelList = new ArrayList<>();;
		List<Course> courseList = courseService.findAll();
		for(Course course : courseList) {
			CourseModel courseModel = mapStructConverter.sourceToDestination(course);
			modelList.add(courseModel);
		}
		return modelList;
	}

	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") int id) throws RecordNotFoundException {
		Course course = courseService.findById(id);
		return new ResponseEntity<Course>(course, new HttpHeaders(), HttpStatus.OK);
	}
=======
	private CourseMapperImpl courseMapper;
//	@GetMapping("/courses")
//	public  List<Course> getCourseBy()
//	{
//		List<CourseModel> modelList = new ArrayList<>();;
//		List<Course> courseList= courseService.findAll();
//		for(Course course : courseList) {
//			CourseModel courseModel = courseMapper.toModel(course);
//			modelList.add(courseModel);
//		}
//		return courseList;
//	}
	
	@GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") int id)
			throws RecordNotFoundException, RecordNotFoundException {
        Course course = courseService.findById(id);

        return new ResponseEntity<Course>(course, new HttpHeaders(), HttpStatus.OK);
    }
>>>>>>> proj1/main

	@GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "5") Integer pageSize,
                        @RequestParam(defaultValue = "id") String sortBy)
    {
        List<Course> listCourses = courseService.getAllCourses(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Course>>(listCourses, new HttpHeaders(), HttpStatus.OK);
    }
<<<<<<< HEAD


=======
>>>>>>> proj1/main
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
	
	
	@GetMapping(value = "/category/{categoryName}")
    public List<Course> getCourseByCategory(String categoryName, Pageable pageable){
		Category category= categoryService.getCategoryByName(categoryName);
		List<Course> list= courseService.getCourseByCategoryName(category, pageable);
     return  list;
    }
	@GetMapping(value = "/category/{categoryName}")
	public List<Course> getCourseByCategory(String categoryName){
		Category category= categoryService.getCategoryByName(categoryName);
		List<Course> list= courseService.findCourseByCategoryName(category);
		return list;

	}
	
	
	

}