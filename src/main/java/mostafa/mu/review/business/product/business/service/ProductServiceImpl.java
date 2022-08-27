package mostafa.mu.review.business.product.business.service;

import static mostafa.mu.review.commons.CommonConstants.ZONE_ID_TEHRAN;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import mostafa.mu.review.business.product.business.mapper.IProductMapper;
import mostafa.mu.review.business.product.persistence.IProductRepository;
import mostafa.mu.review.business.product.persistence.ProductEntity;
import mostafa.mu.review.business.product.presentation.ProductDto;
import mostafa.mu.review.business.provider.business.service.IProviderService;
import mostafa.mu.review.business.provider.presentation.ProviderDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

  private final IProductRepository repository;
  private final IProductMapper mapper;
  private final IProviderService providerService;

  @Override
  public ProductDto add(ProductDto product, Long providerId) {
    ProviderDto provider = providerService.getById(providerId);
    product.setProvider(provider);
    product.setCreationTime(System.currentTimeMillis());
    return mapper.entityToModel(repository.save(mapper.modelToEntity(product)));
  }

  @Override
  public ProductDto getById(Long id) {
    return mapper.entityToModel(
        repository.findById(id).orElseThrow(() -> new RuntimeException("product not exist!")));
  }

  @Override
  public ProductDto update(ProductDto product, Long providerId) {
    ProductEntity productFDB = repository.findById(product.getId())
        .orElseThrow(() -> new RuntimeException("product not exist!"));
    ProviderDto provider = providerService.getById(providerId);
    product.setProvider(provider);
    productFDB.setTitle(product.getTitle());
    productFDB.setPrice(product.getPrice());
    productFDB.setPresentable(product.getPresentable());
    productFDB.setCommentPresentable(product.getCommentPresentable());
    productFDB.setCommentAfterPurchase(product.getCommentAfterPurchase());
    productFDB.setProvider(mapper.modelToEntity(product).getProvider());
    productFDB.setUpdateAt(LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()),
        ZoneId.of(ZONE_ID_TEHRAN)));
    return mapper.entityToModel(repository.save(productFDB));
  }

  @Override
  public void delete(Long id) {
    repository.delete(
        repository.findById(id).orElseThrow(() -> new RuntimeException("product not exist!")));
  }

  @Override
  public ArrayList<ProductDto> getAll() {
    return mapper.toDtoList(repository.findAll());
  }
}
