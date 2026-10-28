package com.doneby.market.domain;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;

@ToString(callSuper = true, includeFieldNames=true)
@Entity(name="_order")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    private Long userId;

    @ManyToMany
    private List<Product> products;
}