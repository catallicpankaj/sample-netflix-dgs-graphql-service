package com.sample.netflixdgs.application.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import com.sample.netflixdgs.application.model.Address;
import com.sample.netflixdgs.application.model.AddressInput;
import com.sample.netflixdgs.application.respository.AddressRepository;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@DgsComponent
public class AddressMutationResolver {

    @Autowired
    AddressRepository addressRepository;

    @DgsMutation
    @Timed("NetflixDGSService:AddressMutationResolver.createAddress")
    public Address createAddress(@InputArgument AddressInput addressData) {
        Address address = Address.builder()
                .addressId(UUID.randomUUID().toString())
                .customerId(addressData.getCustomerId())
                .address1(addressData.getAddress1())
                .address2(addressData.getAddress2())
                .postalCode(addressData.getPostalCode())
                .state(addressData.getState())
                .city(addressData.getCity())
                .build();
        return addressRepository.save(address);
    }
}
