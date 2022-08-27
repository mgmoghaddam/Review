package mostafa.mu.review.user.business.service;

import java.io.IOException;
import mostafa.mu.review.user.presentation.UserDto;

public interface IUserService {

  UserDto add(UserDto userDto) throws IOException;

  UserDto getById(String id) throws IOException;

  UserDto update(UserDto userDto) throws IOException;

  void delete(String id);
}
