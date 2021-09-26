package br.com.alura.resource;

import br.com.alura.model.User;
import br.com.alura.security.ApplicationRoles;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

  @GET
  @RolesAllowed(ApplicationRoles.ADMIN)
  public List<User> list() {
    return User.listAll();
  }

  @POST
  @Transactional
  public void create(User user) {
    User.add(user);
  }
}
