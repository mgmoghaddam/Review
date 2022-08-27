package mostafa.mu.review.user.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mostafa.mu.review.comment.persistence.CommentEntity;
import mostafa.mu.review.commons.CommonConstants;
import mostafa.mu.review.commons.CreatableEntity;
import mostafa.mu.review.product.persistence.ProductEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "user")
public class UserEntity extends CreatableEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = CommonConstants.ID_COLUMN_NAME, unique = true)
  private String id;

  private String fullName;

  private String phoneNumber;

  @ManyToMany(mappedBy = "purchasedUsers",fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  private List<ProductEntity> purchasedProducts = new ArrayList<>();

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  private List<CommentEntity> comments = new ArrayList<>();
}
