package com.tanujit;

import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserResource {

  @Inject
  UserService userService;

  @GET
  @Path("/{userId}")
  public Uni<ApiUser> getById(@PathParam("userId") Long userId){
    return userService.getById(userId);
  }


  @POST
  @Consumes({MediaType.APPLICATION_JSON})
  public Uni<ApiUser> createUser(ApiUser apiUser){
    return userService.createUser(apiUser);
  }
}
