package mostafa.mu.review.business.comment.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection;

@Repository
public interface ICommentRepository extends JpaRepository<CommentEntity, Long>,
    JpaSpecificationExecutorWithProjection<CommentEntity, Long> {

}
