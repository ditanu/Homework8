package com.example.Homework7;

import com.example.Homework7.model.Product;
import com.example.Homework7.model.ShoppingCart;
import com.example.Homework7.repository.ShoppingCartRepository;
import com.example.Homework7.service.ShoppingCartService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShoppingCartServiceTest {

    @Mock
    private ShoppingCartRepository shoppingCartRepository;

    ShoppingCartService shoppingCartService;

    @BeforeEach
    void initUseCase() {
        shoppingCartService = new ShoppingCartService(shoppingCartRepository);
    }

    @Test
    public void savedShoppingCart_Success() {
        ShoppingCart scs = new ShoppingCart();
        Product p1 = new Product();
        List<Product> lista = new ArrayList<>();
        lista.add(p1);
        scs.setProductList(lista);

        when(shoppingCartRepository.save(any(ShoppingCart.class))).thenReturn(scs);

        ShoppingCart savedShoppingCart = shoppingCartRepository.save(scs);
        assertThat(savedShoppingCart.getProductList()).isNotNull();
    }

}
