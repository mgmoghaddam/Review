package mostafa.mu.review.business.product.business.mapper;

import java.util.ArrayList;
import java.util.List;
import mostafa.mu.review.commons.CommonConstants;
import mostafa.mu.review.commons.mapper.IMapper;
import mostafa.mu.review.business.product.persistence.ProductEntity;
import mostafa.mu.review.business.product.presentation.ProductDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = CommonConstants.SPRING, builder = @Builder(disableBuilder = true))
public interface IProductMapper extends IMapper<ProductEntity, ProductDto> {

  ArrayList<ProductDto> toDtoList(List<ProductEntity> entityList);

  List<ProductEntity> toEntityList(ArrayList<ProductDto> dtoList);
}
