package br.com.alura.model;

import br.com.alura.security.ApplicationRoles;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.persistence.*;

@Entity
@UserDefinition
@Table(name = "`user`")
public class User extends PanacheEntityBase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String cpf;

  @Username
  private String username;

  @Password
  private String password;

  @Roles
  private String role;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public static void add(User user) {
    final String hashedPassword = BcryptUtil.bcryptHash(user.getPassword());
    user.setPassword(hashedPassword);
    user.setRole(validate(user.getUsername()));
    user.persist();
  }

  private static String validate(String username) {
    if (username.equals("alura")) {
      return ApplicationRoles.ADMIN;
    }
    return ApplicationRoles.USER;
  }
}