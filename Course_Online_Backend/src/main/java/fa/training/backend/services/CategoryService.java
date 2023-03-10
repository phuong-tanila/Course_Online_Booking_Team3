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
	public List<Category> getAll() {
        return categoryRepository.findAll();
    }
	public Category getCategoryByName(String categoryName) {
        return categoryRepository.findCategoryByName(categoryName);
    }
    public Category getCategoryById(int id) {
        return categoryRepository.findCategoryById(id);
    }

}
