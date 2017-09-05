package com.gft.service;

import com.gft.model.NewProductDto;
import com.gft.model.Product;
import com.gft.repositories.IRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@Path("/Products")
@Api
public class ProductService {
    @Autowired
    private IRepository<Product> repository;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get List of Products",
            response = Product.class,
            responseContainer = "List"
    )
    public Iterable<Product> getProducts() {
        return repository.Items();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get Details of a product, given its Id",
            response = Product.class
    )
    public Product getProduct(@PathParam("id") long id) {
        Product product = repository.GetById(id);
        return product;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Adds a new Product",
            response = Response.class
    )
    public Response addProduct(NewProductDto newProductDto) {
        Product newProduct = new Product();
        newProduct.setName(newProductDto.getName());
        newProduct.setCategory(newProductDto.getCategory());
        repository.Add(newProduct);
        return Response.created(URI.create("/Products/"+newProduct.getId())).build();
    }

}
