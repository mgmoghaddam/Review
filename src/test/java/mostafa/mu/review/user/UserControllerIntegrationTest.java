package mostafa.mu.review.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import mostafa.mu.review.user.presentation.UserDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
@Slf4j
class UserControllerIntegrationTest {

  @LocalServerPort
  private Integer PORT;
  private String MODULE_API;
  private static String crudId = "1";
  private HttpHeaders headers;
  private TestRestTemplate restTemplate;

  @BeforeAll
  void beforeAll() {
    this.headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    this.MODULE_API = "http://localhost:" + PORT + "/v1.0/user";
    this.restTemplate = new TestRestTemplate();
  }

  @Test
  @Order(1)
  void addTest() {
    UserDto user = UserDto.builder().fullName("Mostafa Moghaddam").phoneNumber("+989029119996")
        .build();
    ResponseEntity<UserDto> response = this.restTemplate.exchange(
        this.MODULE_API + "/", HttpMethod.POST, new HttpEntity<>(user, this.headers),
        new ParameterizedTypeReference<UserDto>() {
        }
    );
    assertNotNull(response);
    assertNotNull(response.getBody());
    assertEquals(response.getStatusCode(), HttpStatus.OK);
    UserDto responseDto = response.getBody();
    crudId = responseDto.getId();
    assertEquals(user.getFullName(),responseDto.getFullName());
    assertEquals(user.getPhoneNumber(),responseDto.getPhoneNumber());
  }
}
