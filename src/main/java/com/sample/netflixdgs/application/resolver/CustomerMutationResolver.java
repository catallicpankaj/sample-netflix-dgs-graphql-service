package com.sample.netflixdgs.application.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.sample.netflixdgs.application.model.Customer;
import com.sample.netflixdgs.application.model.CustomerInput;
import com.sample.netflixdgs.application.respository.CustomerRepository;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@DgsComponent
public class CustomerMutationResolver {

    @Autowired
    CustomerRepository customerRepository;

    @DgsData(parentType = "Mutation", field = "createCustomer")
    @Timed("NetflixDGSService:CustomerMutationResolver.createCustomer")
    public Customer createCustomer(@InputArgument CustomerInput customerData) {
        Customer customer = Customer.builder()
                .customerId(UUID.randomUUID().toString())
                .firstName(customerData.getFirstName())
                .lastName(customerData.getLastName())
                .phoneNumber(customerData.getPhoneNumber())
                .email(customerData.getEmail())
                .build();
        return customerRepository.save(customer);
    }

}
