package com.gft;

import javax.inject.Named;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ApplicationConfig {
    @Named
    static class JerseyConfig extends ResourceConfig {
        public JerseyConfig() {
            //The this.packages is failig...
            //Reason:
            //https://stackoverflow.com/questions/42194680/spring-boot-application-wont-run-when-trying-to-run-from-the-jar-file
            //https://github.com/spring-projects/spring-boot/issues/6598
            //https://github.com/spring-projects/spring-boot/issues/1468
            //this.packages("com.gft.service");
            this.register(com.gft.service.ProductService.class);
        }
    }
}
