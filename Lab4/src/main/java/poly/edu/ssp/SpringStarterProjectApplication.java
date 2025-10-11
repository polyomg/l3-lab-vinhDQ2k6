package poly.edu.ssp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * App entry point.
 */
@SpringBootApplication(scanBasePackages = {"poly.edu"})
public class SpringStarterProjectApplication {
    /**
     * Start Spring Boot
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringStarterProjectApplication.class, args);
    }
}