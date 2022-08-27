package mostafa.mu.review.business.provider.presentation;

import java.util.ArrayList;
import java.util.List;

import lombok.*;
import mostafa.mu.review.commons.CreatableModel;
import mostafa.mu.review.business.product.presentation.ProductDto;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDto extends CreatableModel {

  private Long id;
  private String providerName;
  private List<ProductDto> products = new ArrayList<>();
}
