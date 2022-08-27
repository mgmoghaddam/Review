package mostafa.mu.review.provider.presentation;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import mostafa.mu.review.commons.IModel;
import mostafa.mu.review.product.presentation.ProductDto;

@Data
public class ProviderDto implements IModel {

  private Long id;
  private String provideName;
  private List<ProductDto> products = new ArrayList<>();
}
