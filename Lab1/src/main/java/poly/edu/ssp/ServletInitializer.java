package poly.edu.ssp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * WAR bootstrap configuration for external servlet containers.
 */
public class ServletInitializer extends SpringBootServletInitializer {

    /**
     * Configures the application source for WAR deployment.
     *
     * @param application Spring application builder
     * @return configured builder
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringStarterProjectApplication.class);
    }
}