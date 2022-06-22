package com.celean.mymarket.services;

import com.celean.mymarket.dto.ProductDto;
import com.celean.mymarket.exceptions.ResourceNotFoundException;
import com.celean.mymarket.model.Category;
import com.celean.mymarket.model.Product;
import com.celean.mymarket.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private List<Product> productList;

    @Autowired
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Page<Product> findAll(int pageIndex, int pageSize){
        return productRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public List<Product> findByPriceBetween(int minPrice, int maxPrice){
        return productRepository.findQ(minPrice, maxPrice);
    }

    public void addToCart(Product product){
        productList.add(product);
    }

    public void deleteFromCart(Long id){
        productList.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> getCart(){
        return productList;
    }

    public void clearCart(){
        productList.clear();
    }

    @Transactional
    public void updateProductFromDto(ProductDto productDto){
        Product product = findById(productDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Product id = " + productDto.getId() + " not found"));
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Category category = categoryService.findByTitle(productDto
                .getCategoryTitle())
                .orElseThrow(() -> new ResourceNotFoundException("Category title = " + productDto.getCategoryTitle() + " not found"));
        product.setCategory(category);
    }
}
