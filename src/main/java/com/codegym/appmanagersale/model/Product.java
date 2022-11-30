package com.codegym.appmanagersale.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"}),
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    public static final String AVAILABLE = "AVAILABLE";
    public static final String UNAVAILABLE = "UNAVAILABLE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "nvarchar(50) not null")
    private String name;

    @Column(name = "price_in", nullable = false)
    private Long priceIn;

    @Column(name = "price_out", nullable = false)
    private Long priceOut;

    @Column(nullable = false)
    private Integer quantity;

    private String image;

    @Column(columnDefinition = "nvarchar(300)")
    private String description;
    private String status;

    @OneToMany(mappedBy = "product")
    Set<CategoryWithProduct> categoryWithProducts;

    @OneToMany(mappedBy = "product")
    Set<OrderDetail> orderDetails;

    @PrePersist
    public void preCreate() {
        status = AVAILABLE;
    }
}