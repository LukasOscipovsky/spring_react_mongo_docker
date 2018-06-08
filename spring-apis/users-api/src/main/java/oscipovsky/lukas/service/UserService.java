package oscipovsky.lukas.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import oscipovsky.lukas.dto.UserDTO;
import oscipovsky.lukas.model.UserModel;

public interface UserService extends UserDetailsService {

    void save(UserDTO user);
}
