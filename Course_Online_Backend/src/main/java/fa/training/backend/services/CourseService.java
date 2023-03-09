package fa.training.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fa.training.backend.entities.Category;
import fa.training.backend.entities.Course;
import fa.training.backend.entities.User;
import fa.training.backend.exception.RecordNotFoundException;
import fa.training.backend.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	public List<Course> getAllCourses(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Course> pagedResult = courseRepository.findAll(pageable);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Course>();
		}
	}

	public Course findById(int id) throws RecordNotFoundException {
		Optional<Course> course = courseRepository.findById(id);
		if (course.isPresent()) {
			return course.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
//
//	public List<Course> sortCoursesByRating(Integer pageNo, Integer pageSize, String sortBy) {
//		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
//
//		Page<Course> pagedResult = courseRepository.findAll(pageable);
//
//		if (pagedResult.hasContent()) {
//			return pagedResult.getContent();
//		} else {
//			return new ArrayList<Course>();
//		}
//	}

//	public List<Course> getCourseByCategoryName(Category category, Pageable pageable) {
//		Pageable pg = PageRequest.of(0, 5);
//		List<Course> courses = courseRepository.findCourseByCategoryName(category,pg);
//        return courses;
//    }
//	public List<Course> findCourseByCategoryName(Category category){
//		List<Course> courses = courseRepository.findCourseByCategoryName(category);
//		return courses;
//	}
//	public List<Course> sortByRating

}
