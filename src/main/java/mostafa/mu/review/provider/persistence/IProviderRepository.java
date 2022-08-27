package mostafa.mu.review.provider.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection;

@Repository
public interface IProviderRepository extends JpaRepository<ProviderEntity, Long>,
    JpaSpecificationExecutorWithProjection<ProviderEntity, Long> {

}
