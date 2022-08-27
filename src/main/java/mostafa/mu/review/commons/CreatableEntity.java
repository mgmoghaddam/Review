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
@MappedSuperclass
public class CreatableEntity implements IEntity{

  protected LocalDateTime creationTime;
  protected LocalDateTime validTo;
  protected LocalDateTime updateAt;

  public void setTimestamp(Object id) {
    if (id == null) {
      this.setCreationTime(LocalDateTime.now(ZoneId.of(ZONE_ID_TEHRAN)));
    } else {
      this.setUpdateAt(LocalDateTime.now(ZoneId.of(ZONE_ID_TEHRAN)));
    }
  }
}
