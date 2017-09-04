package com.gft.service;

import com.gft.model.Product;
import com.gft.repositories.IRepository;
import org.springframework.stereotype.Component;

import java.net.URI;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/")
public class ProductService {
    public static IRepository<Product> repository;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Product> getProducts() {
        return repository.Items();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") long id) {
        Product product = repository.GetById(id);
        return product;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(Product newProduct) {
        repository.Add(newProduct);
        return Response.created(URI.create("/Products/"+newProduct.getId())).build();
    }

}
