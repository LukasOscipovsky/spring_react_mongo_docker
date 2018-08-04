package oscipovsky.lukas.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Getter
public final class UserModel {

    @Id
    private String id;
    private final String username;
    private final String password;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
