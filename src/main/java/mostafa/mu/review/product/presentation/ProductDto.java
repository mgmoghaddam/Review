package mostafa.mu.review.product.presentation;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mostafa.mu.review.comment.presentation.CommentDto;
import mostafa.mu.review.commons.CreatableModel;
import mostafa.mu.review.commons.IModel;
import mostafa.mu.review.provider.presentation.ProviderDto;
import mostafa.mu.review.user.presentation.UserDto;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductDto extends CreatableModel {

  private Long id;
  private String title;
  private Long price;
  private Boolean presentable;
  private Boolean commentPresentable;
  private Boolean commentAfterPurchase;
  private ProviderDto provider;
  private List<CommentDto> comments = new ArrayList<>();
  private List<UserDto> purchasedUsers = new ArrayList<>();
}
