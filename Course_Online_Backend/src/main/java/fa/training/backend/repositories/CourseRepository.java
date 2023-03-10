package fa.training.backend.repositories;

import java.util.List;
import java.util.Optional;

import fa.training.backend.entities.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fa.training.backend.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	public List<Course> findAll();


	public Optional<Course> findById(int id);



//	public Page<Course> findAll(Pageable pageable);

//	public List<Course> findCourseById(int id, Pageable pageable);

	public List<Course> findCourseByCategoriesIn(List<Category> categories);

	public List<Course> findCourseByCategoriesIn(List<Category> categories, Pageable pageable);


	@Query(" from Course ")
	public List<Course> customGetCouse();
	public List<Course> findByCourseNameIgnoreCaseContaining(String courseName, Pageable pageable);
}
