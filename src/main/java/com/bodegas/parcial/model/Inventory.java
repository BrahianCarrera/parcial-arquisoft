package com.bodegas.parcial.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    public Inventory(int quantity, Product product, Storage storage) {
        this.quantity = quantity;
        this.product = product;
        this.storage = storage;
    }
}
