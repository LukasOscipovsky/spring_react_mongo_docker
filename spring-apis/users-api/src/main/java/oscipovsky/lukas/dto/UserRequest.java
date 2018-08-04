package oscipovsky.lukas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserRequest {

    @JsonProperty("username")
    private final @NonNull  String username;
    @JsonProperty("password")
    private final @NonNull String password;
}
