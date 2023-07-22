package com.study.marketbackend.entity.product;

import com.study.marketbackend.service.dto.product.CreateProductDTO;
import com.study.marketbackend.service.dto.product.UpdateProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "Product")
@Table(name = "products")
@EqualsAndHashCode(of = "productCode")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCode;
    private String productName;
    private Double productPrice;
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;
    private String productBrand;
    private String productSupplier;


    public Product(CreateProductDTO createProductDTO) {
        this.productName = createProductDTO.productName();
        this.productPrice = createProductDTO.productPrice();
        this.productCategory = createProductDTO.productCategory();
        this.productBrand = createProductDTO.productBrand();
        this.productSupplier = createProductDTO.productSupplier();
    }

    public void updateProductPrice(UpdateProductDTO updateProductDTO){
        if (updateProductDTO.productPrice() != null)  this.productPrice = updateProductDTO.productPrice();
    }
}
