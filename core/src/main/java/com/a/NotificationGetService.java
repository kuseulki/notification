package com.a;

import com.a.domain.Notification;
import com.a.domain.NotificationType;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationGetService {

  @Autowired private NotificationRepository repository;

  public Optional<Notification> getNotificationByTypeAndCommentId(NotificationType type, Long commentId){
    return repository.findByTypeAndCommentId(type, commentId);
  }

  public Optional<Notification> getNotificationByTypeAndPostId(NotificationType type, Long postId){
    return repository.findByTypeAndCommentId(type, postId);
  }

}
