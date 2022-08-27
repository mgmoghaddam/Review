package mostafa.mu.review.commons.mapper;


import mostafa.mu.review.commons.IEntity;
import mostafa.mu.review.commons.IModel;

public interface IMapper<E extends IEntity, M extends IModel> extends ICustomMapper {

//    @Mapping(target = "creationTime", expression = "java(LocalDateTime.ofInstant(entity.getCreationTime(), ZoneId.of(\"Asia/Tehran\")))")
    M entityToModel(E entity);

//    @Mapping(target = "creationTime", expression = "java(model.getCreationTime().atZone(ZoneId.of(\"Asia/Tehran\")).toInstant().toEpochMilli())")
    E modelToEntity(M model);
}
