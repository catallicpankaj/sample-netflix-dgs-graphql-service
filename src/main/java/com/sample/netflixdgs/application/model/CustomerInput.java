package com.sample.netflixdgs.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInput {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
