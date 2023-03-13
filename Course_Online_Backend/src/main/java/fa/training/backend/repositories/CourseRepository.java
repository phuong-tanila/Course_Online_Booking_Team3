package fa.training.backend.repositories;

import java.util.List;
import java.util.Optional;

import fa.training.backend.entities.Category;
import fa.training.backend.model.CourseModel;
import fa.training.backend.model.FeedbackModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fa.training.backend.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
