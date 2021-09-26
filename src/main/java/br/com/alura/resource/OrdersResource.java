package br.com.alura.resource;

import br.com.alura.model.Order;
import br.com.alura.security.ApplicationRoles;
import br.com.alura.service.OrderService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrdersResource {

  private final OrderService service;

  public OrdersResource(OrderService service) {
    this.service = service;
  }

  @POST
  @RolesAllowed(ApplicationRoles.USER)
  public void create(@Context SecurityContext securityContext, Order order) {
    service.addOrder(securityContext.getUserPrincipal().getName(), order);
  }
}
