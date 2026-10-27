package com.doneby.market.domain;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;

@ToString(callSuper = true)
@Entity
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long userId;

    @OneToMany(mappedBy="userId")
    private List<Product> products;
}