package mostafa.mu.review.user.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, String>,
    JpaSpecificationExecutorWithProjection<UserEntity, String> {


  Optional<UserEntity> findByPhoneNumber(String phoneNumber);
}
