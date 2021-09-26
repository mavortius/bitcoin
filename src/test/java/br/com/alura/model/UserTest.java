package br.com.alura.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserTest {

  @Test
  @DisplayName("User findByIdOptional should return an optional user.")
  void shouldReturnOptionalUser() {
    PanacheMock.mock(User.class);
    User user = new User();
    Optional<PanacheEntityBase> optionalUser = Optional.of(user);

    Mockito.when(User.findByIdOptional(40)).thenReturn(optionalUser);

    assertSame(user, User.findByIdOptional(40).get());
  }
}