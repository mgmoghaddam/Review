package mostafa.mu.review.business.user.business.mapper;

import mostafa.mu.review.commons.CommonConstants;
import mostafa.mu.review.commons.mapper.IMapper;
import mostafa.mu.review.business.user.persistence.UserEntity;
import mostafa.mu.review.business.user.presentation.UserDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = CommonConstants.SPRING, builder = @Builder(disableBuilder = true))
public interface IUserMapper extends IMapper<UserEntity, UserDto> {

}
