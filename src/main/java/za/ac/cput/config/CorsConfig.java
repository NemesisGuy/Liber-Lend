package za.ac.cput.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Value("${cors.allowed-origins}")
    private String allowedOrigins;
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @SuppressWarnings("NullableProblems")
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        // .allowedOrigins(allowedOrigins) //user this for when locking down the allowed origins
                        .allowedOriginPatterns(allowedOrigins) //use this for when allowing all origins
                        .allowedMethods("*")
                        .allowedOrigins("*")
                        .allowedHeaders("*")
                        // .allowCredentials(true)
                        .exposedHeaders("*")
                        .maxAge(3600);
                System.out.println("CorsConfig was triggered");

            }
        };
    }

}
