package oscipovsky.lukas.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import oscipovsky.lukas.dto.UserRequest;

public interface UserService extends UserDetailsService {

    void save(UserRequest user);
}
