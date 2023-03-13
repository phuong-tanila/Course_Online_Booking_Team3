package fa.training.backend.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import fa.training.backend.entities.Course;
import fa.training.backend.exception.RecordNotFoundException;
import fa.training.backend.repositories.CourseRepository;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    FeedbackService feedbackService;

    /*all list-course*/
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    /*Phan trang sort list-course theo id*/
    public List<Course> getAllCourses(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Course> pagedResult = courseRepository.findAll(pageable);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Course>();
        }
    }

    /*Phan trang list-course*/
    public List<Course> getAllCourses(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Course> pagedResult = courseRepository.findAll(pageable);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Course>();
        }
    }

//    public List<Course> findByCourseName(Integer pageNo, Integer pageSize, HashMap<String, String> orderHashMap, String courseName) {
//        Pageable pageable = ServiceHelper.getPageable(pageNo, pageSize, orderHashMap);
//        return courseRepository.findByCourseNameIgnoreCaseContaining(courseName, pageable);
//    }

    public Course findById(int id) throws RecordNotFoundException {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return course.get();
        } else {
            throw new RecordNotFoundException("No course exist for given id");
        }
    }

    //    public List<Course> getCourseByCategory(Integer pageNo, Integer pageSize, String sortBy, String direction, List<Category> categories) {
//        Sort sort;
//        if (direction.equalsIgnoreCase("desc")) {
//            sort = Sort.by(Sort.Direction.DESC, sortBy);
//        } else {
//            sort = Sort.by(Sort.Direction.ASC, sortBy);
//        }
//        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
//        List<Course> courses = courseRepository.findCourseByCategoriesIn(categories, pageable);
//        return courses;
//    }

}
