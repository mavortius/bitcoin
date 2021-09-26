package br.com.alura.resource;

import br.com.alura.model.Order;
import br.com.alura.security.ApplicationRoles;
import br.com.alura.service.OrderService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrdersResource {

  private final OrderService service;

  public OrdersResource(OrderService service) {
    this.service = service;
  }

  @GET
  @RolesAllowed(ApplicationRoles.ADMIN)
  public List<Order> list() {
    return service.listAll();
  }

  @POST
  @RolesAllowed(ApplicationRoles.USER)
  public void create(@Context SecurityContext securityContext, Order order) {
    service.addOrder(securityContext.getUserPrincipal().getName(), order);
  }
}
