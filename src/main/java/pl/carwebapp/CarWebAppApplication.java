package pl.carwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("pl.carwebapp.data")
@EnableTransactionManagement
@SpringBootApplication
@EnableScheduling
public class CarWebAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarWebAppApplication.class, args);
    }
}
