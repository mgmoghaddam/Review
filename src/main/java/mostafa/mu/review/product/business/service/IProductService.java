package mostafa.mu.review.product.business.service;

import java.util.ArrayList;
import mostafa.mu.review.product.presentation.ProductDto;

public interface IProductService {

  ProductDto add(ProductDto product, Long providerId);

  ProductDto getById(Long id);

  ProductDto update(ProductDto product, Long providerId);

  void delete(Long id);

  ArrayList<ProductDto> getAll();
}
