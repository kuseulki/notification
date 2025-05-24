package com.a.client;

import com.a.domain.User;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class UserClient {

  private final Map<Long, User> users = new HashMap<>();

  public UserClient() {
    users.put(1L, new User(1L, "user1","profileImageUrl1"));
    users.put(2L, new User(2L, "user2","profileImageUrl2"));
    users.put(3L, new User(3L, "user3","profileImageUrl3"));
    users.put(4L, new User(4L, "user4","profileImageUrl4"));
    users.put(5L, new User(5L, "user5","profileImageUrl5"));
  }

  public User getUser(Long id){
    return users.get(id);
  }

  public Boolean getIsFollowing(Long followerId, Long followedId) {
    return true;
  }

}
