package fa.training.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.backend.entities.Category;
import fa.training.backend.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}
	public List<Category> getCategoryCategoryName(String categoryName) {
		return categoryRepository.findByCategoryNameIgnoreCaseContaining(categoryName);
	}
}
