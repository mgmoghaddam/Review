package mostafa.mu.review.user.business.service;


import java.io.IOException;
import lombok.RequiredArgsConstructor;
import mostafa.mu.review.user.business.mapper.IUserMapper;
import mostafa.mu.review.user.persistence.IUserRepository;
import mostafa.mu.review.user.persistence.UserEntity;
import mostafa.mu.review.user.presentation.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    return mapper.entityToModel(repository.save(mapper.modelToEntity(userDto)));
  }

  @Override
  public UserDto getById(String id) throws IOException {
    return mapper.entityToModel(
        repository.findById(id).orElseThrow(() -> new IOException("user not exist!")));
  }

  @Override
  public UserDto update(UserDto userDto) throws IOException {
    UserEntity userEntity = repository.findById(userDto.getId())
        .orElseThrow(() -> new IOException("user not exist!"));
    userEntity.setFullName(userDto.getFullName());
    userEntity.setPhoneNumber(userDto.getPhoneNumber());
    return mapper.entityToModel(repository.save(userEntity));
  }

  @Override
  public void delete(String id) {
    repository.delete(
        repository.findById(id).orElseThrow(() -> new RuntimeException("user not exist!")));
  }
}
