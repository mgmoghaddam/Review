package mostafa.mu.review.user.business.mapper;

import mostafa.mu.review.commons.CommonConstants;
import mostafa.mu.review.commons.mapper.IMapper;
import mostafa.mu.review.user.persistence.UserEntity;
import mostafa.mu.review.user.presentation.UserDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = CommonConstants.SPRING, builder = @Builder(disableBuilder = true))
public interface IUserMapper extends IMapper<UserEntity, UserDto> {

}
