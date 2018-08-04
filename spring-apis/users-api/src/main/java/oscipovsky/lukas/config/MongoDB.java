package oscipovsky.lukas.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "oscipovsky.lukas.repository")
public class MongoDB extends AbstractMongoConfiguration {

    @Value("${mongo.db.url}")
    private String mongoDbUrl;

    @Value("${mongo.db.port}")
    private Integer mongoDbPort;

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(mongoDbUrl, mongoDbPort);
    }

    @Override
    protected String getDatabaseName() {
        return "app";
    }
}
