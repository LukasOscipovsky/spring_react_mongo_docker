package oscipovsky.lukas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import oscipovsky.lukas.dto.UserRequest;
import oscipovsky.lukas.model.UserModel;
import oscipovsky.lukas.repository.UserRepository;
import oscipovsky.lukas.service.UserService;

import java.util.Collections;

@Component
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(UserRequest userDTO) {
        var user = new UserModel(userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword()));

        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User Not Found"));

        return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
