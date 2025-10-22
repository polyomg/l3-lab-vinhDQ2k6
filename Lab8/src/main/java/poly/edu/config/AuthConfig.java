package poly.edu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import poly.edu.interceptor.AuthInterceptor;
import poly.edu.interceptor.LogInterceptor;

@Configuration
public class AuthConfig implements WebMvcConfigurer {

    @Autowired
    AuthInterceptor authInterceptor;

    @Autowired
    LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Add LogInterceptor to all secured pages
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/mail/**", "/access-history");

        // Add AuthInterceptor to protect secured pages
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/mail/**", "/access-history")
                .excludePathPatterns("/auth/**");
    }
}
