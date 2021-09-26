package br.com.alura.resource;

import br.com.alura.model.Order;
import br.com.alura.repository.OrderRepository;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

@Path("/orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrdersResource {

  private final OrderRepository repository;

  public OrdersResource(OrderRepository repository) {
    this.repository = repository;
  }

  @POST
  @Transactional
  public void create(Order order) {
    order.setDate(LocalDate.now());
    order.setStatus("SENT");
    repository.persist(order);
  }
}
