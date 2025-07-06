package com.tecnoshop.updateProducts.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @NotBlank
    @Size(min = 10, max = 300)
    private String description;

    @NotNull
    @DecimalMin("0.01")
    private Double price;

    @NotNull
    @Min(0)
    private Integer stock;

    @NotBlank
    @Size(min = 3, max = 20)
    private String sku;

    private Boolean isPublished = true;
}
