package poly.edu.ssp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * WAR init for external servlet container.
 */
public class ServletInitializer extends SpringBootServletInitializer {
    /**
     * Register main app class
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
        return app.sources(SpringStarterProjectApplication.class);
    }
}