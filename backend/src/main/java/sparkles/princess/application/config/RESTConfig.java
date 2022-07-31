package sparkles.princess.application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * Configuration for the use of REST between the Reaart front-end and Java Spring Boot back-end.
 * Cross-origin resource sharing (CORS) is an HTTP-header based mechanism that allows restricted resources to access
 * resources outside of a given domain. It defines a way in which a browser and server can interact to determine whether
 * it is safe to allow the cross-origin request.
 *
 * @author Johnny Cold
 * */
@Configuration
public class RESTConfig {

    @Value("${cors.allowed.origins}")
    private String[] allowedOrigins;

    @Value("${cors.allowed.headers}")
    private String[] allowedHeaders;

    @Value("${cors.allowed.methods}")
    private String[] allowedMethods;

    @Bean
    public FilterRegistrationBean corsFilterRegistration(){
        FilterRegistrationBean bean  = new FilterRegistrationBean(corsFilter());
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList(allowedOrigins));
        corsConfiguration.setAllowedMethods(Arrays.asList(allowedMethods));
        corsConfiguration.setAllowedHeaders(Arrays.asList(allowedHeaders));
        corsConfiguration.addExposedHeader("Authorization");
        configurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(configurationSource);
    }
}
