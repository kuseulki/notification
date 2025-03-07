package com.a.controller;

import com.a.response.SetLastReadAtResponse;
import com.a.service.LastReadAtService;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/user-notifications")
public class NotificationReadController implements NotificationReadControllerSpec {

  private final LastReadAtService service;

  @Override
  @PutMapping("/{userId}/read")   // put : 덮어쓰기
  public SetLastReadAtResponse setLastReadAt(@PathVariable(value = "userId") Long userId) {
    Instant lastReadAt = service.setLastReadAt(userId);
    return new SetLastReadAtResponse(lastReadAt);
  }

}
