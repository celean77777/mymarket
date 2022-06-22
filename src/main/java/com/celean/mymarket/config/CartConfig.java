package com.celean.mymarket.config;

import com.celean.mymarket.model.Product;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("com.celean.mymarket")
public class CartConfig {
    @Bean
    public List<Product> getProductCart(){
        List<Product> productList = new ArrayList<>();
        return productList;
    }
}
