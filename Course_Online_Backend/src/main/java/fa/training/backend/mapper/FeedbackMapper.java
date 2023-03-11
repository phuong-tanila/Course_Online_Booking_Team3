package fa.training.backend.mapper;

import fa.training.backend.entities.Feedback;
import fa.training.backend.model.FeedbackModel;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface FeedbackMapper {
    FeedbackModel toModel(Feedback feedback);
    Feedback toEntity(FeedbackModel feedbackModel);
}
