package fa.training.backend.mapper;

import fa.training.backend.entities.Course;
import fa.training.backend.model.CourseModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface CourseMapper {
    CourseModel toModel(Course course);
    Course toEntity(CourseModel courseModel);
    List<CourseModel> toListModel(List<Course> course);
}
