package com.neha.cloud.services;

import com.neha.cloud.models.Product;
import com.neha.cloud.models.ProductFilterBody;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;


@Service
public class ProductService {
    private static List<Product> products;
    static {
        products = new ArrayList<>(5);
        products.add(new Product(UUID.randomUUID(),"Product 1","Category 1"));
        products.add(new Product(UUID.randomUUID(),"Product 2","Category 1"));
        products.add(new Product(UUID.randomUUID(),"Product 3","Category 2"));
        products.add(new Product(UUID.randomUUID(),"Product 4","Category 3"));
        products.add(new Product(UUID.randomUUID(),"Product 5","Category 4"));
    }

    public List<Product> getAllProducts () {
        return products;
    }

    public List<Product> getFilteredProducts(final ProductFilterBody productFilterBody) {
        return products.stream().filter(product ->
            isNotEmpty(productFilterBody.getListOfIds()) && productFilterBody.getListOfIds().contains(product.getId()) ||
            isNotEmpty(productFilterBody.getListOfNames()) && productFilterBody.getListOfNames().contains(product.getName()) ||
            isNotEmpty(productFilterBody.getListOfCategories()) && productFilterBody.getListOfCategories().contains(product.getCategory())
        ).collect(Collectors.toList());
    }
}
