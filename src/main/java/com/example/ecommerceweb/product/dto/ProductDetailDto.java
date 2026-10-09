package com.example.ecommerceweb.product.dto;

import com.example.ecommerceweb.productsku.dto.ProductSkuDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDetailDto {


    @NotNull
    private long id;
    @NotEmpty(message = "Invalid name.")
    private String name;
    private String description;
    private String brand;
    private List<ProductSkuDto> productSkuDto;

}
