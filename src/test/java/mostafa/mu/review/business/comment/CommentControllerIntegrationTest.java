package mostafa.mu.review.business.comment;

import lombok.extern.slf4j.Slf4j;
import mostafa.mu.review.business.comment.presentation.CommentDto;
import mostafa.mu.review.business.product.presentation.ProductDto;
import mostafa.mu.review.business.provider.presentation.ProviderDto;
import mostafa.mu.review.business.user.presentation.UserDto;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
public class CommentControllerIntegrationTest {

    @LocalServerPort
    private Integer PORT;
    private String MODULE_API_COMMENT;
    private String MODULE_API_PROVIDER;
    private String MODULE_API_USER;
    private static Long crudId = 1L;
    private HttpHeaders headers;
    private TestRestTemplate restTemplate;

    @BeforeAll
    void beforeAll() {
        this.headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        this.MODULE_API_COMMENT = "http://localhost:" + PORT + "/api/v1.0/comment";
        this.MODULE_API_PROVIDER = "http://localhost:" + PORT + "/api/v1.0/provider";
        this.MODULE_API_USER = "http://localhost:" + PORT + "/api/v1.0/user";
        this.restTemplate = new TestRestTemplate();
    }

    @Test
    @Order(1)
    void createTest() {
        //first need to add provider, product and user

        //create provider with product
        ProviderDto provider = ProviderDto.builder()
                .providerName("digi")
                .products(List.of(ProductDto.builder()
                        .title("productA")
                        .price(500000L)
                        .presentable(true)
                        .commentPresentable(true)
                        .commentAfterPurchase(false)
                        .build()))
                .build();
        ResponseEntity<ProviderDto> responseProvider = this.restTemplate.exchange(
                this.MODULE_API_PROVIDER + "/", HttpMethod.POST, new HttpEntity<>(provider, this.headers),
                new ParameterizedTypeReference<ProviderDto>() {
                }
        );
        assertEquals(HttpStatus.OK, responseProvider.getStatusCode());
        assertThat(responseProvider.getBody()).isNotNull();
        assertEquals(provider.getProviderName(), responseProvider.getBody().getProviderName());
        assertEquals(provider.getProducts().get(0).getTitle(), responseProvider.getBody().getProducts().get(0).getTitle());
        assertEquals(provider.getProducts().get(0).getPrice(), responseProvider.getBody().getProducts().get(0).getPrice());


        //create user
        UserDto user = UserDto.builder()
                .fullName("Mostafa")
                .phoneNumber("+989029119996").build();
        ResponseEntity<UserDto> responseUser = this.restTemplate.exchange(
                this.MODULE_API_USER + "/", HttpMethod.POST, new HttpEntity<>(user, this.headers),
                new ParameterizedTypeReference<UserDto>() {
                }
        );
        assertNotNull(responseUser);
        assertNotNull(responseUser.getBody());
        assertEquals(HttpStatus.OK, responseUser.getStatusCode());
        assertEquals(user.getFullName(), responseUser.getBody().getFullName());
        assertEquals(user.getPhoneNumber(), responseUser.getBody().getPhoneNumber());


        //create comment
        CommentDto comment = CommentDto.builder()
                .presentable(true)
                .comment("it's an awesome test")
                .vote(10L)
                .product(ProductDto.builder().id(provider.getProducts().get(0).getId()).build())
                .user(UserDto.builder().id(user.getId()).build())
                .build();
        ResponseEntity<CommentDto> responseComment = this.restTemplate.exchange(
                this.MODULE_API_COMMENT + "/" + "?username=" + responseUser.getBody().getId() + "&productId=" +
                        responseProvider.getBody().getProducts().get(0).getId(),
                HttpMethod.POST, new HttpEntity<>(comment, this.headers),
                new ParameterizedTypeReference<CommentDto>() {
                }
        );

        assertEquals(HttpStatus.OK, responseComment.getStatusCode());
        assertThat(responseComment.getBody()).isNotNull();
        assertEquals(comment.getComment(), responseComment.getBody().getComment());
        assertEquals(comment.getVote(), responseComment.getBody().getVote());
        assertEquals(comment.getPresentable(), responseComment.getBody().getPresentable());
    }
}
