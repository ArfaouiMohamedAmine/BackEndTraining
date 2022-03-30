package org.exoplatform.training.Services;

import java.util.List;

import org.exoplatform.training.Entity.Products;

public interface ProductInterface
{
    List<Products> getAllProducts() throws Exception;
    Products addProduct(Products a);
    void deleteProduct(long id);
}
