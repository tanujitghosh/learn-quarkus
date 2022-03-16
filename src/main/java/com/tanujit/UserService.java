package com.tanujit;

import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService {

  @ReactiveTransactional
  public Uni<ApiUser> createUser(ApiUser user){
    User userDb = new User();
    userDb.setUserName(user.getUserName());
    userDb.setAddress(user.getAddress());
    return userDb.persistAndFlush()
        .map(u -> user.withUserId(userDb.id));
  }

  public Uni<ApiUser> getById(Long userId){
    User userDb = new User();
    return User.findById(userId)
        .onItem().ifNotNull().transform(u -> {
            ApiUser apiUser = new ApiUser();
            apiUser.setUserId(((User)u).id);
            apiUser.setUserName(((User)u).getUserName());
            apiUser.setAddress(((User)u).getAddress());
            return apiUser;
        })
        .onItem().ifNull().failWith(new UserNotFoundException("user not found"));
  }
}
