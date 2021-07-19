package com.sample.netflixdgs.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressInput {
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postalCode;
    private String customerId;
}
