package mostafa.mu.review.business.provider.business.service;

import static mostafa.mu.review.commons.CommonConstants.ZONE_ID_TEHRAN;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import mostafa.mu.review.business.provider.business.mapper.IProviderMapper;
import mostafa.mu.review.business.provider.persistence.IProviderRepository;
import mostafa.mu.review.business.provider.persistence.ProviderEntity;
import mostafa.mu.review.business.provider.presentation.ProviderDto;
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
        repository.findById(id).orElseThrow(() -> new RuntimeException("provider not exist!")));
  }

  @Override
  public ProviderDto update(ProviderDto provider) {
    ProviderEntity providerEntity = repository.findById(provider.getId())
        .orElseThrow(() -> new RuntimeException("provider not exist!"));
    providerEntity.setProviderName(provider.getProviderName());
    providerEntity.setUpdateAt(LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()),
        ZoneId.of(ZONE_ID_TEHRAN)));
    return mapper.entityToModel(repository.save(providerEntity));
  }

  @Override
  public void delete(Long id) {
    repository.delete(
        repository.findById(id).orElseThrow(() -> new RuntimeException("provider not exist!")));
  }

  @Override
  public ArrayList<ProviderDto> getAll() {
    return mapper.toDtoList(repository.findAll());
  }
}
