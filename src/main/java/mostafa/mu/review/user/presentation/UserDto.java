package mostafa.mu.review.user.presentation;


import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mostafa.mu.review.comment.persistence.CommentEntity;
import mostafa.mu.review.commons.IModel;
import mostafa.mu.review.product.persistence.ProductEntity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements IModel {

  private String id;
  private String fullName;
  private String phoneNumber;
  private List<ProductEntity> purchasedProducts = new ArrayList<>();
  private List<CommentEntity> comments = new ArrayList<>();
}
