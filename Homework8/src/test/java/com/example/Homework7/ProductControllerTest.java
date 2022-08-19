package com.example.Homework7;

import com.example.Homework7.controller.ProductController;
import com.example.Homework7.model.CreateProductRequest;
import com.example.Homework7.model.Product;
import com.example.Homework7.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @MockBean
    ProductService productService;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_return_created_product() throws Exception {
        CreateProductRequest request = new CreateProductRequest();
        request.setName("test product");
        Product product = new Product();
        product.setName(request.getName());
        when(productService.saveProduct(any(Product.class))).thenReturn(product);

        mockMvc.perform(post("/products"))
                .content(mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .andExcept(status().isOk())
                .andExcept(jsonPath("$.name")).value(request.getName());
    }
}
