package com.neha.cloud.controllers.product.v1;

import com.neha.cloud.models.Product;
import com.neha.cloud.models.ProductFilterBody;
import com.neha.cloud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/find", method = POST)
    public List<Product> getFilteredProducts(@RequestBody ProductFilterBody productFilterBody) {
        return productService.getFilteredProducts(productFilterBody);
    }
}
