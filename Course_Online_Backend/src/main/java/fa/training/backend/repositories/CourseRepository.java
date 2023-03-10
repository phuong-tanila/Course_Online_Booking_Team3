package fa.training.backend.repositories;

import java.util.List;
import java.util.Optional;

import fa.training.backend.entities.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.backend.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	public List<Course> findAll();

	public Optional<Course> findById();



//	public Page<Course> findAll(Pageable pageable);

//	public List<Course> findCourseById(int id, Pageable pageable);

	public List<Course> findCourseByCategoryName(Category category);

	public List<Course> findCourseByCategoryName(Category category, Pageable pageable);
}
