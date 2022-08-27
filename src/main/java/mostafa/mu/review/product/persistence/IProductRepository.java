package mostafa.mu.review.product.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Long>,
    JpaSpecificationExecutorWithProjection<ProductEntity, Long> {

}
