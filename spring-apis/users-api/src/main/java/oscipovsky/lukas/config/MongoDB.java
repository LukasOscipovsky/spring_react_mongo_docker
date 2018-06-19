package oscipovsky.lukas.config;

import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;

@Configuration
@EnableMongoRepositories(basePackages = "oscipovsky.lukas.repository")
public class MongoDB extends AbstractMongoConfiguration {

    private static final String HOST = "172.18.0.2";
    private static final Integer PORT = 27017;

    private static final String MONGO_DB_URL = "localhost"; // use only with development
    private static final String MONGO_DB_NAME = "embeded_db"; // use only with development

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(HOST, PORT);
    }

    @Override
    protected String getDatabaseName() {
        return "app";
    }

    @Bean
    public MongoTemplate mongoTemplate() throws IOException { // use only with development
        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
        mongo.setBindIp(MONGO_DB_URL);
        MongoClient mongoClient = mongo.getObject();
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);
        return mongoTemplate;
    }
}
