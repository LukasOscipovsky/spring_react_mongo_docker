package oscipovsky.lukas.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "oscipovsky.lukas.repository")
public class MongoDB extends AbstractMongoConfiguration {

    private static final String HOST = "127.0.0.1";
    private static final Integer PORT = 27017;

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(HOST, PORT);
    }

    @Override
    protected String getDatabaseName() {
        return "app";
    }
}
