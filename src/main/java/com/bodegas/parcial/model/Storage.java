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
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private List<Inventory> inventories;
}
