package mostafa.mu.review.provider.business.service;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import mostafa.mu.review.provider.business.mapper.IProviderMapper;
import mostafa.mu.review.provider.persistence.IProviderRepository;
import mostafa.mu.review.provider.persistence.ProviderEntity;
import mostafa.mu.review.provider.presentation.ProviderDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class ProviderServiceImpl implements IProviderService {

  private final IProviderRepository repository;
  private final IProviderMapper mapper;

  @Override
  public ProviderDto add(ProviderDto provider) {
    provider.setCreationTime(System.currentTimeMillis());
    return mapper.entityToModel(repository.save(mapper.modelToEntity(provider)));
  }

  @Override
  public ProviderDto getById(Long id) {
    return mapper.entityToModel(
        repository.findById(id).orElseThrow(() -> new RuntimeException("provider noe exist!")));
  }

  @Override
  public ProviderDto update(ProviderDto provider) {
    ProviderEntity providerEntity = repository.findById(provider.getId())
        .orElseThrow(() -> new RuntimeException("provider noe exist!"));
    providerEntity.setProviderName(provider.getProvideName());
    return mapper.entityToModel(repository.save(providerEntity));
  }

  @Override
  public void delete(Long id) {
    repository.delete(
        repository.findById(id).orElseThrow(() -> new RuntimeException("provider noe exist!")));
  }

  @Override
  public ArrayList<ProviderDto> getAll() {
    return mapper.toDtoList(repository.findAll());
  }
}
