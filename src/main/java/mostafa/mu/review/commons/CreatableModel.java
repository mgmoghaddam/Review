package mostafa.mu.review.commons;

import static mostafa.mu.review.commons.CommonConstants.ZONE_ID_TEHRAN;

import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatableModel implements IModel {

  protected Long creationTime;
  protected Long validTo;
  protected Long updateAt;
}
