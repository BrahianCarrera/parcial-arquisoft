package com.bodegas.parcial.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;
    private String category;


    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private List<Inventory> inventories;
}
