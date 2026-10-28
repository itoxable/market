package com.doneby.market.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.ToString;

@ToString(callSuper = true, includeFieldNames=true)
@Entity
public class Address extends BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String address;
    private String address2;

    @NotNull
    private String postcode;

    @NotNull
    private String city;

    @NotNull
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
