package mostafa.mu.review.business.comment.presentation;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import mostafa.mu.review.business.comment.business.service.ICommentService;
import mostafa.mu.review.commons.SingleResultModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static mostafa.mu.review.business.constants.Endpoints.*;

@RestController
@RequestMapping(API + VERSION1 + COMMENT)
@Validated
@RequiredArgsConstructor
public class CommentController {

  private final ICommentService service;


  // I have to mention that if we have security and authentication process we can get username from that
  @PostMapping("/")
  public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto comment,
      @RequestParam Long username, @RequestParam Long productId) throws IOException {
    return ResponseEntity.ok(service.addComment(comment, username, productId));
  }

  @GetMapping("/{commentId}")
  public ResponseEntity<CommentDto> getById(@PathVariable Long commentId) {
    return ResponseEntity.ok(service.getById(commentId));
  }

  @PutMapping("/")
  public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto)
      throws IOException {
    return ResponseEntity.ok(service.editComment(commentDto));
  }

  @DeleteMapping("/{commentId}")
  public ResponseEntity<SingleResultModel<Boolean>> deleteComment(@PathVariable Long commentId)
      throws IOException {
    service.deleteComment(commentId);
    return ResponseEntity.ok(new SingleResultModel<>(true));
  }

}
