package com.doneby.market.domain;

import jakarta.persistence.*;
import lombok.ToString;

@ToString(callSuper = true)
@Entity
public class Address extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String address;
    private String address2;
    private String postcode;
    private String city;
    private String country;

    private Long userId;

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}
