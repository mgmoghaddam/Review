package mostafa.mu.review.business.user.business.service;


import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import lombok.RequiredArgsConstructor;
import mostafa.mu.review.business.user.business.mapper.IUserMapper;
import mostafa.mu.review.business.user.persistence.IUserRepository;
import mostafa.mu.review.business.user.persistence.UserEntity;
import mostafa.mu.review.business.user.presentation.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static mostafa.mu.review.commons.CommonConstants.ZONE_ID_TEHRAN;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

  private final IUserRepository repository;
  private final IUserMapper mapper;

  @Override
  public UserDto add(UserDto userDto) throws IOException {
    if (repository.findByPhoneNumber(userDto.getPhoneNumber()).isPresent()) {
      throw new IOException("user with this phone number exist!");
    }
    userDto.setCreationTime(System.currentTimeMillis());
    return mapper.entityToModel(repository.save(mapper.modelToEntity(userDto)));
  }

  @Override
  public UserDto getById(Long id) throws IOException {
    return mapper.entityToModel(
        repository.findById(id).orElseThrow(() -> new IOException("user not exist!")));
  }

  @Override
  public UserDto update(UserDto userDto) throws IOException {
    UserEntity userEntity = repository.findById(userDto.getId())
        .orElseThrow(() -> new IOException("user not exist!"));
    userEntity.setFullName(userDto.getFullName());
    userEntity.setPhoneNumber(userDto.getPhoneNumber());
    userEntity.setUpdateAt(LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()),
        ZoneId.of(ZONE_ID_TEHRAN)));
    return mapper.entityToModel(repository.save(userEntity));
  }

  @Override
  public void delete(Long id) {
    repository.delete(
        repository.findById(id).orElseThrow(() -> new RuntimeException("user not exist!")));
  }
}
