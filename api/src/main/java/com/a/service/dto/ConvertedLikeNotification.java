package com.a.service.dto;

import com.a.domain.NotificationType;
import java.time.Instant;
import lombok.Getter;

@Getter
public class ConvertedLikeNotification extends ConvertedNotification{

  private final String userName;
  private final String userProfileImageUrl;
  private final long userCount;
  private final String postImageUrl;

  public ConvertedLikeNotification(
      String id,
      NotificationType type,
      Instant occurredAt,
      Instant lastUpdatedAt,
      String userName,
      String userProfileImageUrl,
      long userCount,
      String postImageUrl
  ) {
    super(id, type, occurredAt, lastUpdatedAt);
    this.userName = userName;
    this.userProfileImageUrl = userProfileImageUrl;
    this.userCount = userCount;
    this.postImageUrl = postImageUrl;
  }
}
