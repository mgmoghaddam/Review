package mostafa.mu.review.provider.presentation;

import static mostafa.mu.review.constants.Endpoints.API;
import static mostafa.mu.review.constants.Endpoints.PROVIDER;
import static mostafa.mu.review.constants.Endpoints.VERSION1;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import mostafa.mu.review.commons.SingleResultModel;
import mostafa.mu.review.provider.business.service.IProviderService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API + VERSION1 + PROVIDER)
@RequiredArgsConstructor
@Validated
public class ProviderController {

  private final IProviderService service;

  @PostMapping("/")
  public ResponseEntity<ProviderDto> add(@RequestBody ProviderDto providerDto) {
    return ResponseEntity.ok(service.add(providerDto));
  }

  @GetMapping("/")
  public ResponseEntity<ArrayList<ProviderDto>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("/{providerId}")
  public ResponseEntity<ProviderDto> getById(@PathVariable Long providerId) {
    return ResponseEntity.ok(service.getById(providerId));
  }

  @PutMapping("/")
  public ResponseEntity<ProviderDto> update(@RequestBody ProviderDto providerDto) {
    return ResponseEntity.ok(service.update(providerDto));
  }

  @DeleteMapping("/{providerId}")
  public ResponseEntity<SingleResultModel<Boolean>> delete(@PathVariable Long providerId) {
    service.delete(providerId);
    return ResponseEntity.ok(new SingleResultModel<>(true));
  }
}
