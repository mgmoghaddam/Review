package mostafa.mu.review.business.comment.business.service;

import static mostafa.mu.review.commons.CommonConstants.ZONE_ID_TEHRAN;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.RequiredArgsConstructor;
import mostafa.mu.review.business.comment.business.mapper.ICommentMapper;
import mostafa.mu.review.business.comment.persistence.CommentEntity;
import mostafa.mu.review.business.comment.persistence.ICommentRepository;
import mostafa.mu.review.business.comment.presentation.CommentDto;
import mostafa.mu.review.business.product.business.service.IProductService;
import mostafa.mu.review.business.product.presentation.ProductDto;
import mostafa.mu.review.business.user.business.service.IUserService;
import mostafa.mu.review.business.user.presentation.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService {

  private final ICommentRepository commentRepository;
  private final ICommentMapper mapper;

  private final IUserService userService;
  private final IProductService productService;

  private static final String COMMENT_NOT_EXIST = "comment not exist!";

  @Override
  public CommentDto addComment(CommentDto commentDto, Long username, Long productId)
      throws IOException {
    ProductDto product = productService.getById(productId);
    UserDto user = userService.getById(username);
    commentDto.setProduct(product);
    commentDto.setUser(user);
    commentDto.setCreationTime(System.currentTimeMillis());
    CommentEntity commentEntity = mapper.modelToEntity(commentDto);
    if (product.getCommentAfterPurchase() && !userService.getById(username).getPurchasedProducts()
        .contains(commentEntity.getProduct())) {
      throw new RuntimeException("You can set review only after buy this product!");
    }
    return mapper.entityToModel(commentRepository.save(commentEntity));
  }

  @Override
  public CommentDto getById(Long commentId) {
    return mapper.entityToModel(commentRepository.findById(commentId)
        .orElseThrow(() -> new RuntimeException(COMMENT_NOT_EXIST)));
  }

  @Override
  public CommentDto editComment(CommentDto commentDto) {
    CommentEntity commentEntity = commentRepository.findById(commentDto.getId())
        .orElseThrow(() -> new RuntimeException(COMMENT_NOT_EXIST));
    commentEntity.setComment(commentDto.getComment());
    commentEntity.setScore(commentDto.getScore());
    commentEntity.setPresentable(commentDto.getPresentable());
    commentEntity.setUpdateAt(
        LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()),
            ZoneId.of(ZONE_ID_TEHRAN)));
    return mapper.entityToModel(commentRepository.save(commentEntity));
  }

  @Override
  public void deleteComment(Long id) {
    commentRepository.delete(commentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException(COMMENT_NOT_EXIST)));
  }
}
