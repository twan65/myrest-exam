package org.myrest.web.service;

import lombok.RequiredArgsConstructor;
import org.myrest.web.model.Role;
import org.myrest.web.model.User;
import org.myrest.web.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AccountService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Transactional
  public User save(User user) {

    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
    user.setEnabled(true);

    Role role = new Role();
    role.setId(1l);
    user.getRoles().add(role);

    return userRepository.save(user);
  }


}
