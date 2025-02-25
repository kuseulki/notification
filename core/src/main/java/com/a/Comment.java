package com.a;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Comment {

  private Long id;
  private Long userId;
  private String content;
  private Instant createdAt;

}
