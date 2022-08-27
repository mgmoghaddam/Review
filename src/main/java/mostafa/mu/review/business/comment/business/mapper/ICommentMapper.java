package mostafa.mu.review.business.comment.business.mapper;


import java.util.ArrayList;
import java.util.List;
import mostafa.mu.review.business.comment.persistence.CommentEntity;
import mostafa.mu.review.business.comment.presentation.CommentDto;
import mostafa.mu.review.commons.CommonConstants;
import mostafa.mu.review.commons.mapper.IMapper;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = CommonConstants.SPRING, builder = @Builder(disableBuilder = true))
public interface ICommentMapper extends IMapper<CommentEntity, CommentDto> {

  ArrayList<CommentDto> toDtoList(List<CommentEntity> entityList);

  List<CommentEntity> toEntityList(ArrayList<CommentDto> dtoList);
}
