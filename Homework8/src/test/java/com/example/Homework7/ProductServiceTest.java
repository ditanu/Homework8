package com.example.Homework7;

import com.example.Homework7.model.Product;
import com.example.Homework7.model.ProductType;
import com.example.Homework7.repository.ProductRepository;
import com.example.Homework7.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Test
    public void it_should_save_product() throws Exception {
        Product testProduct = new Product(null, ProductType.ELC, "Light", "2030",30, Boolean.TRUE, 1000);
        when(productRepository.save((any(Product.class))).thenReturn(new Product()));

        Product created = productService.saveProduct(testProduct);
        assertThat(created.getName()).isSameAs(testProduct.getName());
    }

}
