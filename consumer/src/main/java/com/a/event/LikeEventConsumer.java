package com.a.event;

import com.a.task.LikeAddTask;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LikeEventConsumer {

  @Autowired
  private LikeAddTask likeAddTask;

  @Bean("like")
  public Consumer<LikeEvent> like(){
    return event -> {
      if (event.getType() == LikeEventType.ADD) {
        likeAddTask.processEvent(event);

      }

    };

  }

}
