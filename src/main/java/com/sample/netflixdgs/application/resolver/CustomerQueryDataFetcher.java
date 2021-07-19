package com.sample.netflixdgs.application.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.sample.netflixdgs.application.model.Address;
import com.sample.netflixdgs.application.model.Customer;
import com.sample.netflixdgs.application.model.CustomerDTO;
import com.sample.netflixdgs.application.respository.AddressRepository;
import com.sample.netflixdgs.application.respository.CustomerRepository;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@DgsComponent
public class CustomerQueryDataFetcher {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    @DgsQuery
    @Timed("NetflixDGSService:CustomerMutationResolver.allCustomers")
    public List<CustomerDTO> allCustomers(){
        List<Customer> customers = (List<Customer>)customerRepository.findAll();
        List<CustomerDTO> customersDTO = new ArrayList<>();
        customers.stream().forEach(customer->{
            CustomerDTO customerDTO = new CustomerDTO();
            BeanUtils.copyProperties(customer, customerDTO, "addresses");
            List<Address> addresses = addressRepository.getAddressByCustomerId(customer.getCustomerId())
                    .orElse(new ArrayList<Address>());
            customerDTO.setAddresses(addresses);
            customersDTO.add(customerDTO);
        });
        return customersDTO;
    }




    @DgsQuery
    @Timed("NetflixDGSService:CustomerMutationResolver.customersById")
    public Customer customersById(String customerId){
        return customerRepository.findById(customerId).orElse(new Customer());
    }
}
