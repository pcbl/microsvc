package com.gft;

import javax.inject.Named;
import javax.ws.rs.ApplicationPath;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
public class ApplicationConfig {
    @Component
    @ApplicationPath("/api")
    public class JerseyConfig extends ResourceConfig {
        public JerseyConfig() {
            //The this.packages is failing...
            //Reason:
            //https://stackoverflow.com/questions/42194680/spring-boot-application-wont-run-when-trying-to-run-from-the-jar-file
            //https://github.com/spring-projects/spring-boot/issues/6598
            //https://github.com/spring-projects/spring-boot/issues/1468
            //this.packages("com.gft.service");
            register(com.gft.service.ProductService.class);
            configureSwagger();
        }

        private void configureSwagger() {
            register(ApiListingResource.class);
            register(SwaggerSerializers.class);
            BeanConfig beanConfig = new BeanConfig();
            beanConfig.setVersion("0.0.1");
            beanConfig.setSchemes(new String[]{"http"});
            beanConfig.setHost("localhost:8080");
            beanConfig.setBasePath("/");
            beanConfig.setDescription("Sample");
            beanConfig.setContact("VIIGit");
            beanConfig.setResourcePackage("com.gft.service");
            beanConfig.setPrettyPrint(true);
            beanConfig.setScan(true);
        }
    }
}
