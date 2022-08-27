package mostafa.mu.review.business.user.business.service;

import java.io.IOException;
import mostafa.mu.review.business.user.presentation.UserDto;

public interface IUserService {

  UserDto add(UserDto userDto) throws IOException;

  UserDto getById(Long id) throws IOException;

  UserDto update(UserDto userDto) throws IOException;

  void delete(Long id);
}
