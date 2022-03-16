package com.tanujit;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<Exception> {

  @Override
  public Response toResponse(Exception e) {
    if(e instanceof UserNotFoundException) {
      ApiError apiError = new ApiError();
      apiError.setExceptionType(e.getClass().getName());
      apiError.setExceptionMessage(e.getMessage());
      return Response.status(Response.Status.NOT_FOUND)
          .entity(apiError).build();
    }else{
      ApiError apiError = new ApiError();
      apiError.setExceptionType(e.getClass().getName());
      apiError.setExceptionMessage(e.getMessage());
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
          .entity(apiError).build();
    }
  }
}
