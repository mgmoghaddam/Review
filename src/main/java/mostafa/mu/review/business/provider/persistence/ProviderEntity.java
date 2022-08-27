package mostafa.mu.review.business.provider.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mostafa.mu.review.commons.CreatableEntity;
import mostafa.mu.review.business.product.persistence.ProductEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "provider")
public class ProviderEntity extends CreatableEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String providerName;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "product_providers", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "provider_id", referencedColumnName = "id"))
  private List<ProductEntity> products = new ArrayList<>();
}
