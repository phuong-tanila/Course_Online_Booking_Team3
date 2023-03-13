package fa.training.backend.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import fa.training.backend.entities.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fa.training.backend.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    public List<Course> findAll();

//    public List<Course> findCoursesBy

    public Optional<Course> findById(int id);

    @Query("select c from Course c where c.createDate < ?1 and c.id = ?2")
    Optional<Course> findWithStartDateTimeBeforePresent(Date date, int id);

//	public Page<Course> findAll(Pageable pageable);

    //	public List<Course> findCourseById(int id, Pageable pageable);
    @Query("SELECT c FROM Course c JOIN c.categories ct WHERE ct.id = ?1")
    public List<Course> findCoursesByCategory(int categoryId, Pageable pageable);

    public List<Course> findCourseByCategoriesIn(List<Category> categories);

    public List<Course> findCourseByCategoriesIn(List<Category> categories, Pageable pageable);


    @Query(" from Course ")
    public List<Course> customGetCouse();

    public List<Course> findByCourseNameIgnoreCaseContaining(String courseName, Pageable pageable);
}
