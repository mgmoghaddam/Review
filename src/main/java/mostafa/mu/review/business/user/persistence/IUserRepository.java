package mostafa.mu.review.business.user.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long>,
    JpaSpecificationExecutorWithProjection<UserEntity, Long> {


  Optional<UserEntity> findByPhoneNumber(String phoneNumber);
}
