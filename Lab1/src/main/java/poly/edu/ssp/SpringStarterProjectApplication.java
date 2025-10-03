package poly.edu.ssp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application bootstrap configuring component scan for the poly.edu namespace.
 */
@SpringBootApplication(scanBasePackages = {"poly.edu"})
public class SpringStarterProjectApplication {
    /**
     * Launches the Spring Boot application.
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringStarterProjectApplication.class, args);
    }
}