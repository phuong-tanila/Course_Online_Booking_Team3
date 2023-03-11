package fa.training.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public class CategoryModel {
    @JsonProperty
    public int id;
    public String categoryName;
    public Set<CourseModel> courses;

}
