package com.gft.service;

import com.gft.model.Product;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/Products")
public class ProductService {
    private static List<Product> Products = new ArrayList<Product>();
    static {
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
        Products.add(product1);
        Products.add(product2);
        Products.add(product3);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        return Products;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") long id) {
        Product product = null;
        for (Product c : Products) {
            if (c.getId() == id)
                product = c;
        }
        return product;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(Product newProduct) {
        newProduct.setId(Products.size()+1);
        Products.add(newProduct);
        return Response.created(URI.create("/Products/"+newProduct.getId())).build();
    }

}
