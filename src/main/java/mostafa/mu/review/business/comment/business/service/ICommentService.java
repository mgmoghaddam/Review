package mostafa.mu.review.business.comment.business.service;

import java.io.IOException;
import mostafa.mu.review.business.comment.presentation.CommentDto;

public interface ICommentService {

  CommentDto addComment(CommentDto commentDto, Long username, Long productId) throws IOException;

  CommentDto getById(Long commentId);

  CommentDto editComment(CommentDto commentDto) throws IOException;

  void deleteComment(Long id) throws IOException;
}
