package oscipovsky.lukas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import oscipovsky.lukas.model.UserModel;


public interface UserRepository extends MongoRepository<UserModel, String> {

    @Query(value = "{ 'username' : ?0 }")
    UserModel findByUsername(String username);
}
