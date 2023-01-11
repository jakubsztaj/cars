package pl.carwebapp;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableMongoRepositories
@SpringBootApplication
@EnableScheduling
@EnableEncryptableProperties
public class    CarWebAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarWebAppApplication.class, args);
    }
}
