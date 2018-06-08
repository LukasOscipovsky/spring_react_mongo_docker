package oscipovsky.lukas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

    private String username;
    private String password;

    public UserDTO(@JsonProperty("username") String username, @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
