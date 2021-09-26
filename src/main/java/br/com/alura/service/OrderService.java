package br.com.alura.service;

import br.com.alura.model.Order;
import br.com.alura.model.User;
import br.com.alura.repository.OrderRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class OrderService {
  private final OrderRepository repository;

  public OrderService(OrderRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public void addOrder(String username, Order order) {
    final PanacheQuery<User> userOptional = User.find("select u from User u where u.username = ?1", username);
    final User user = userOptional.firstResultOptional().orElseThrow();
    order.setUserId(user.getId());
    order.setDate(LocalDate.now());
    order.setStatus("SENT");
    repository.persist(order);
  }

  public List<Order> listAll() {
    return repository.listAll();
  }
}
