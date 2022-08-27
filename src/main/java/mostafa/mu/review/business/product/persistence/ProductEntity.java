package mostafa.mu.review.business.product.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mostafa.mu.review.business.comment.persistence.CommentEntity;
import mostafa.mu.review.commons.CreatableEntity;
import mostafa.mu.review.business.provider.persistence.ProviderEntity;
import mostafa.mu.review.business.user.persistence.UserEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "product")
public class ProductEntity extends CreatableEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private Long price;
  private Boolean presentable;
  private Boolean commentPresentable;
  private Boolean commentAfterPurchase;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "provider_id")
  private ProviderEntity provider;
  @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<CommentEntity> comments = new ArrayList<>();
  @ManyToMany
  @JoinColumn(name = "user_id")
  private List<UserEntity> purchasedUsers = new ArrayList<>();
}
