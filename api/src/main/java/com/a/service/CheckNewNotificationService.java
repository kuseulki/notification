package com.a.service;

import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CheckNewNotificationService {

  private final NotificationGetService notificationGetService;
  private final LastReadAtService lastReadAtService;

  public boolean checkNewNotification(long userId)  {

    // lastReadAt vs latestUpdateAt (가장 최신으로 업데이트 된 시간)
    Instant latestUpdatedAt = notificationGetService.getLatestUpdatedAt(userId);
    if(latestUpdatedAt == null) {
      return false;
    }

    Instant lastReadAt = lastReadAtService.getLastReadAt(userId);
    if(lastReadAt == null) {
      return true;
    }
    return latestUpdatedAt.isAfter(lastReadAt);
  }
}
