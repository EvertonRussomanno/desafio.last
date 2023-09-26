package com.dio.desafio.last.controller;

import com.dio.desafio.last.controller.dto.ProductDto;
import com.dio.desafio.last.domain.model.product.Product;
import com.dio.desafio.last.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/products")
@Tag(name = "Product Controller", description = "RESTful API for managing storage products.")
public record ProductController(ProductService productService) {

    @GetMapping
    @Operation(summary = "Get all products", description = "Retrieve a list of all registered products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    public ResponseEntity<List<ProductDto>> findAll() {
        var products = productService.findAll();
        var productsDto = products.stream().map(ProductDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(productsDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a product by ID", description = "Retrieve a specific product based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
        var product = productService.findById(id);
        return ResponseEntity.ok(new ProductDto(product));
    }

    @PostMapping
    @Operation(summary = "Create a new product", description = "Create a new product and return the created product's data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid product data provided")
    })
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto userDto) {
        var product = productService.create(userDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();
        return ResponseEntity.created(location).body(new ProductDto(product));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a product", description = "Update the data of an existing product based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "422", description = "Invalid product data provided")
    })
    public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody ProductDto productDto) {
        var product = productService.update(id, productDto.toModel());
        return ResponseEntity.ok(new ProductDto(product));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product", description = "Delete an existing product based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
