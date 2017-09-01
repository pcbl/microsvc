package com.gft;

import com.gft.model.Product;
import com.gft.repositories.InMemoryRepository;
import com.gft.repositories.MongoRepository;
import com.gft.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.UnknownHostException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {

        //  ProductService.repository = SetupMongoRepository();
        ProductService.repository = SetupInMemoryRepository();
        SpringApplication.run(Application.class, args);

    }

    private static MongoRepository<Product> SetupMongoRepository() throws IOException {
        MongoRepository<Product> toReturn = new MongoRepository<>("Microservice77","Product");

        return toReturn;
    }

    private static InMemoryRepository<Product> SetupInMemoryRepository()
    {
        InMemoryRepository<Product> toReturn = new InMemoryRepository<>();
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Milk");
        product1.setCategory("Beverages");
        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Salami");
        product2.setCategory("Meat");
        Product product3 = new Product();
        product3.setId(3);
        product3.setName("Coke");
        product3.setCategory("Beverages");
        toReturn.Add(product1);
        toReturn.Add(product2);
        toReturn.Add(product3);
        return toReturn;
    }
}