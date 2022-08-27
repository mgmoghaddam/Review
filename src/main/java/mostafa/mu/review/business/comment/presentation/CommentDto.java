package mostafa.mu.review.business.comment.presentation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.*;
import mostafa.mu.review.commons.CreatableModel;
import mostafa.mu.review.business.product.presentation.ProductDto;
import mostafa.mu.review.business.user.presentation.UserDto;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
