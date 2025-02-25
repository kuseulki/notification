package com.a;

import com.a.domain.Notification;
import com.a.domain.NotificationType;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
  Optional<Notification> findById(String id);

  Notification save(Notification notification);

  void deleteById(String id);

  @Query("{ 'type':  ?0, 'commentId': ?1 }")
  Optional<Notification> findByTypeAndCommentId(NotificationType type, Long commentId);

  @Query("{ 'type':  ?0, 'postId': ?1 }")
  Optional<Notification> findByTypeAndPostId(NotificationType type, Long postId);


}
