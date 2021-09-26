package br.com.alura.repository;

import br.com.alura.model.Order;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

@QuarkusTest
class OrderRepositoryTest {

  @InjectMock
  private OrderRepository repository;

  @Test
  @DisplayName("listAll should return list of orders.")
  void shouldReturnOrderList() {
    Order firstOrder = new Order();
    Order secondOrder = new Order();
    List<Order> orders = new ArrayList<>();
    orders.add(firstOrder);
    orders.add(secondOrder);
    Mockito.when(repository.listAll()).thenReturn(orders);

    assertSame(secondOrder, repository.listAll().get(1));
  }
}