package mostafa.mu.review.provider.presentation;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mostafa.mu.review.commons.CreatableModel;
import mostafa.mu.review.commons.IModel;
import mostafa.mu.review.product.presentation.ProductDto;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProviderDto extends CreatableModel {

  private Long id;
  private String provideName;
  private List<ProductDto> products = new ArrayList<>();
}
