package mostafa.mu.review.commons;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class CommonConstants {

  public static final String BASE_PACKAGE = "mostafa.mu";
  public static final DateTimeFormatter DAY_FORMATTER = DateTimeFormat
      .forPattern("yyyy-MM-dd");
  public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormat
      .forPattern("HH:mm");
  public static final DateTimeFormatter DAY_TIME_FORMATTER = DateTimeFormat
      .forPattern("yyyy-MM-dd HH:mm:ss");

  public static final String SPRING = "spring";
  public static final String AND_SIGN = "&";
  public static final String QUESTION_SIGN = "?";
  public static final String CREATION = "creation";
  public static final String VALID_TO = "valid_to";
  public static final String UPDATE_AT = "update_at";
  public static final String ZONE_ID_TEHRAN = "Asia/Tehran";
  public static final String SYSTEM_UUID = "system-uuid";
  public static final String UUID_STRATEGY = "uuid";
  public static final String ID_COLUMN_NAME = "UUID";
}
