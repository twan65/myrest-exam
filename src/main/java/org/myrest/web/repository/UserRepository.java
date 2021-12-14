package org.myrest.web.repository;

import org.myrest.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long>  {

  User findByUsername(String username);
}
