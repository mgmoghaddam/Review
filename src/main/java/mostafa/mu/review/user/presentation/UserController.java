package mostafa.mu.review.user.presentation;


import static mostafa.mu.review.constants.Endpoints.API;
import static mostafa.mu.review.constants.Endpoints.USER;
import static mostafa.mu.review.constants.Endpoints.VERSION1;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import mostafa.mu.review.commons.SingleResultModel;
import mostafa.mu.review.user.business.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API + VERSION1 + USER)
@RequiredArgsConstructor
public class UserController {

  private final IUserService userService;

  @PostMapping("/")
  public ResponseEntity<UserDto> addUser(@RequestBody UserDto user) throws IOException {
    return ResponseEntity.ok(userService.add(user));
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getUser(@PathVariable String id) throws IOException {
    return ResponseEntity.ok(userService.getById(id));
  }

  @PutMapping("/")
  public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) throws IOException {
    return ResponseEntity.ok(userService.update(user));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<SingleResultModel<Boolean>> deleteUser(@PathVariable String id) {
    userService.delete(id);
    return ResponseEntity.ok(new SingleResultModel<>(true));
  }
}
