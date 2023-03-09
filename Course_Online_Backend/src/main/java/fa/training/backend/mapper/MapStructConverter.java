package fa.training.backend.mapper;

import fa.training.backend.entities.User;
import fa.training.backend.model.UserModel;
import org.mapstruct.Mapper;

import fa.training.backend.entities.Course;
import fa.training.backend.model.CourseModel;

@Mapper(componentModel="spring")
public interface MapStructConverter {
	CourseModel sourceToDestination(Course course);
	Course destinationToSource(CourseModel destination);
	UserModel sourceToDestination(User user);
	User destinationToSource(UserModel destination);

}
