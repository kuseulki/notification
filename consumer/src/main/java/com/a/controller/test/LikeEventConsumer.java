package com.a.controller.test;

import static com.a.event.LikeEventType.ADD;
import static com.a.event.LikeEventType.REMOVE;

import com.a.event.LikeEvent;
import com.a.task.LikeAddTask;
import com.a.task.LikeRemoveTask;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LikeEventConsumer {

  @Autowired private LikeAddTask likeAddTask;
  @Autowired private LikeRemoveTask likeRemoveTask;

  @Bean("like")
  public Consumer<LikeEvent> like(){
    return event -> {
      if (event.getType() == ADD) {
        likeAddTask.processEvent(event);
      } else if (event.getType() == REMOVE) {
        likeRemoveTask.processEvent(event);
      }
    };
  }

}
