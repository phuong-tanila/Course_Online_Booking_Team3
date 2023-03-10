package fa.training.backend.mapper.implement;

import fa.training.backend.entities.Course;
import fa.training.backend.mapper.MapStructConverter;
import fa.training.backend.model.CourseModel;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface CourseMapperImpl extends MapStructConverter<Course, CourseModel> {
}
