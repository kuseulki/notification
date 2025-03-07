package com.a.task;

import com.a.service.NotificationGetService;
import com.a.service.NotificationRemoveService;
import com.a.domain.NotificationType;
import com.a.event.FollowEvent;
import org.springframework.stereotype.Component;

@Component
public class FollowRemoveTask {

  private final NotificationGetService getService;
  private final NotificationRemoveService removeService;

  public FollowRemoveTask(NotificationGetService getService, NotificationRemoveService removeService) {
    this.getService = getService;
    this.removeService = removeService;
  }

  public void processEvent(FollowEvent event) {
    getService.getNotificationByTypeAndUserIdAndFollowerId(NotificationType.FOLLOW, event.getTargetUserId(),
            event.getUserId())
        .ifPresent(
            notification -> removeService.deleteById(notification.getId())
        );
  }
}