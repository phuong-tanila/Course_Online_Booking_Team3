package fa.training.backend.mapper;

<<<<<<< HEAD
import fa.training.backend.entities.User;
import fa.training.backend.model.UserModel;
import org.mapstruct.Mapper;
=======
>>>>>>> proj1/main

public interface MapStructConverter<Entity, Model> {
    Model toModel(Entity e);

<<<<<<< HEAD
@Mapper(componentModel="spring")
public interface MapStructConverter {
	CourseModel sourceToDestination(Course course);
	Course destinationToSource(CourseModel destination);
	UserModel sourceToDestination(User user);
	User destinationToSource(UserModel destination);

=======
    Entity toEntity(Model o);
>>>>>>> proj1/main
}
