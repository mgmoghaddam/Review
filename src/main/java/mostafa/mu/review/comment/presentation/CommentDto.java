package mostafa.mu.review.comment.presentation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mostafa.mu.review.commons.CreatableModel;
import mostafa.mu.review.commons.IModel;
import mostafa.mu.review.product.presentation.ProductDto;
import mostafa.mu.review.user.presentation.UserDto;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@EqualsAndHashCode(callSuper = true)
public class CommentDto extends CreatableModel {

  private Long id;
  private Boolean presentable;
  @NotNull
  private String comment;
  @Min(value = 0)
  @Max(value = 10)
  private Long vote;
  private ProductDto product;
  private UserDto user;
}
