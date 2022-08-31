package com.educative.ecommerce.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Integer id;

    private  @NotNull String name;
    private  @NotNull  String imageUrl;
    private  @NotNull  double price;
    private  @NotNull  String description;
    private  @NotNull  Integer categoryid;
}
