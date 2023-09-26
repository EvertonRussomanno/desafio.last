package com.dio.desafio.last.service.impl;

import com.dio.desafio.last.domain.model.product.Product;
import com.dio.desafio.last.domain.model.repository.ProductRepository;
import com.dio.desafio.last.service.exception.BusinessException;
import com.dio.desafio.last.service.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class ProductServiceImpl {

    private static final Long UNCHANGEABLE_USER_ID = 1L;

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){this.productRepository = productRepository;}

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return this.productRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Product create(Product productToCreate) {
        ofNullable(productToCreate).orElseThrow(() -> new BusinessException("Product to create must not be null."));
        ofNullable(productToCreate.getProductName()).orElseThrow(() -> new BusinessException("Product name must not be null."));
        ofNullable(productToCreate.getDescription().getBarcode()).orElseThrow(() -> new BusinessException("Product barcode must not be null."));

        this.validateChangeableId(productToCreate.getId(), "created");
        if (productRepository.existsByProductName(productToCreate.getProductName())) {
            throw new BusinessException("This product name already exists.");
        }
        if (productRepository.existsByBarcode(productToCreate.getDescription().getBarcode())) {
            throw new BusinessException("This product barcode already exists.");
        }
        return this.productRepository.save(productToCreate);
    }

    @Transactional
    public Product update(Long id, Product productToUpdate) {
        this.validateChangeableId(id, "updated");
        Product dbUser = this.findById(id);
        if (!dbUser.getId().equals(productToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }

        dbUser.setProductName(productToUpdate.getProductName());
        dbUser.setDescription(productToUpdate.getDescription());
        dbUser.setPriceComposition(productToUpdate.getPriceComposition());
        dbUser.setStorage(productToUpdate.getStorage());
        dbUser.setImages(productToUpdate.getImages());

        return this.productRepository.save(dbUser);
    }

    @Transactional
    public void delete(Long id) {
        this.validateChangeableId(id, "deleted");
        Product dbUser = this.findById(id);
        this.productRepository.delete(dbUser);
    }

    private void validateChangeableId(Long id, String operation) {
        if (UNCHANGEABLE_USER_ID.equals(id)) {
            throw new BusinessException("User with ID %d can not be %s.".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }

}
