package mostafa.mu.review.provider.business.service;

import java.util.ArrayList;
import mostafa.mu.review.provider.presentation.ProviderDto;

public interface IProviderService {

  ProviderDto add(ProviderDto provider);

  ProviderDto getById(Long id);

  ProviderDto update(ProviderDto provider);

  void delete(Long id);

  ArrayList<ProviderDto> getAll();
}
