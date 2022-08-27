package mostafa.mu.review.comment.business.service;

import java.io.IOException;
import mostafa.mu.review.comment.presentation.CommentDto;

public interface ICommentService {

  CommentDto addComment(CommentDto commentDto, String username, Long productId) throws IOException;

  CommentDto getById(Long commentId);

  CommentDto editComment(CommentDto commentDto) throws IOException;

  void deleteComment(Long id) throws IOException;
}
