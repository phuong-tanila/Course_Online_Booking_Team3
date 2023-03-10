package fa.training.backend.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category extends BaseEntity{
	@Column
	private String categoryName;
	@ManyToMany(mappedBy = "categories")
	private Set<Course> courses;
}
