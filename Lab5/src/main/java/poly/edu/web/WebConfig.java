package poly.edu.web;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private ServletContext servletContext;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String uploadsPath = servletContext.getRealPath("/uploads");
        if (uploadsPath != null) {
            if (!uploadsPath.endsWith("/")) uploadsPath += "/";
            registry.addResourceHandler("/uploads/**")
                    .addResourceLocations("file:" + uploadsPath);
        }
    }
}
