package sparkles.princess.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"sparkles.application", "sparkles.model", "sparkles.service"})
@EntityScan({"sparkles.application", "sparkles.model", "sparkles.service"})
@EnableJpaRepositories({"sparkles.repository"})
public class CleoApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CleoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CleoApplication.class, args);
    }
}
