package mostafa.mu.review.business.user.presentation;


import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mostafa.mu.review.business.comment.persistence.CommentEntity;
import mostafa.mu.review.commons.CreatableModel;
import mostafa.mu.review.business.product.persistence.ProductEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto extends CreatableModel {

  private Long id;
  private String fullName;
  private String phoneNumber;
  private List<ProductEntity> purchasedProducts = new ArrayList<>();
  private List<CommentEntity> comments = new ArrayList<>();
}
