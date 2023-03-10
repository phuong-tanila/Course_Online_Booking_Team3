package fa.training.backend.mapper.implement;

import fa.training.backend.entities.Course;
import fa.training.backend.entities.Feedback;
import fa.training.backend.mapper.MapStructConverter;
import fa.training.backend.model.CourseModel;
import fa.training.backend.model.FeedbackModel;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface FeedbackMapperImpl extends MapStructConverter<Feedback, FeedbackModel> {
}
