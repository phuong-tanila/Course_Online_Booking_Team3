package fa.training.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.backend.entities.Category;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findByCategoryNameIgnoreCaseContaining(String categoryName);
}
