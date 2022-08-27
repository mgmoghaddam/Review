package mostafa.mu.review.business.provider.business.mapper;

import java.util.ArrayList;
import java.util.List;
import mostafa.mu.review.commons.CommonConstants;
import mostafa.mu.review.commons.mapper.IMapper;
import mostafa.mu.review.business.provider.persistence.ProviderEntity;
import mostafa.mu.review.business.provider.presentation.ProviderDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = CommonConstants.SPRING, builder = @Builder(disableBuilder = true))
public interface IProviderMapper extends IMapper<ProviderEntity, ProviderDto> {

  ArrayList<ProviderDto> toDtoList(List<ProviderEntity> entityList);

  List<ProviderEntity> toEntityList(ArrayList<ProviderDto> dtoList);
}
