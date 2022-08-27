package mostafa.mu.review.business.product.presentation;

import java.util.ArrayList;
import java.util.List;

import lombok.*;
import mostafa.mu.review.business.comment.presentation.CommentDto;
import mostafa.mu.review.commons.CreatableModel;
import mostafa.mu.review.business.provider.presentation.ProviderDto;
import mostafa.mu.review.business.user.presentation.UserDto;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
