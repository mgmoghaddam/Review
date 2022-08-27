package mostafa.mu.review.product.presentation;

import static mostafa.mu.review.constants.Endpoints.API;
import static mostafa.mu.review.constants.Endpoints.PRODUCT;
import static mostafa.mu.review.constants.Endpoints.VERSION1;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import mostafa.mu.review.commons.SingleResultModel;
import mostafa.mu.review.product.business.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API + VERSION1 + PRODUCT)
@Validated
@RequiredArgsConstructor
public class ProductController {

  private final IProductService service;

  @PostMapping("/")
  public ResponseEntity<ProductDto> add(@RequestBody ProductDto productDto,
      @RequestParam Long providerId) {
    return ResponseEntity.ok(service.add(productDto, providerId));
  }

  @GetMapping("/")
  public ResponseEntity<ArrayList<ProductDto>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("/{productId}")
  public ResponseEntity<ProductDto> getById(@PathVariable Long productId) {
    return ResponseEntity.ok(service.getById(productId));
  }

  @PutMapping("/")
  public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto,
      @RequestParam Long providerId) {
    return ResponseEntity.ok(service.update(productDto, providerId));
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<SingleResultModel<Boolean>> delete(@PathVariable Long productId) {
    service.delete(productId);
    return ResponseEntity.ok(new SingleResultModel<>(true));
  }
}
