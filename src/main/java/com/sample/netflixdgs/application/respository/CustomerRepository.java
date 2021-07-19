package com.sample.netflixdgs.application.respository;

import com.sample.netflixdgs.application.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

}
