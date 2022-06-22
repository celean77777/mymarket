package com.celean.mymarket.dto;

import com.celean.mymarket.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;

    @NotNull(message = "Товар должен иметь название")
    @Length(min = 3, max = 255, message = "Длина названия товара должна составлять 3-255 символов")
    private String title;

    @Min(value = 1, message = "Цена товара должна быть не менее 1 рубля")
    private int price;

    @NotNull(message = "Товар должен иметь категорию")
    private String categoryTitle;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.categoryTitle = product.getCategory().getTitle();
    }
}
