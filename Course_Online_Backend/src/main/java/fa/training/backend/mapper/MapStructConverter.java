package fa.training.backend.mapper;

import fa.training.backend.entities.User;
import fa.training.backend.model.UserModel;
import org.mapstruct.Mapper;

public interface MapStructConverter<Entity, Model> {
    Model toModel(Entity e);

    Entity toEntity(Model o);
}
