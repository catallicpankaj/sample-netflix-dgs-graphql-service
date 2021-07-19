package com.sample.netflixdgs.application.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.sample.netflixdgs.application.model.Address;
import com.sample.netflixdgs.application.respository.AddressRepository;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@DgsComponent
public class AddressQueryDataFetcher {
    @Autowired
    AddressRepository addressRepository;

    @DgsQuery
    @Timed("NetflixDGSService:AddressQueryDataFetcher.allAddresses")
    public List<Address> allAddresses(){
        return (List<Address>)addressRepository.findAll();
    }

    @DgsQuery
    @Timed("NetflixDGSService:AddressQueryDataFetcher.addressesByCustomerId")
    public List<Address> addressesByCustomerId(String customerId){
        return addressRepository.getAddressByCustomerId(customerId).orElse(new ArrayList<Address>());
    }



    @DgsQuery
    @Timed("NetflixDGSService:AddressQueryDataFetcher.addressesByAddressId")
    public Address addressesByAddressId(String addressId){
        return addressRepository.findById(addressId).orElse(new Address());
    }
}
