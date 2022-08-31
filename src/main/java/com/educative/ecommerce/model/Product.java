package com.educative.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

private  @NotNull  String name;
private  @NotNull  String imageUrl;
private  @NotNull  double price;
private  @NotNull  String description;

@ManyToOne
@JoinColumn(name = "category_id")
 Category category;


    public Product() {

    }
}
