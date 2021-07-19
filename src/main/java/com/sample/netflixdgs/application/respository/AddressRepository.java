package com.sample.netflixdgs.application.respository;

import com.sample.netflixdgs.application.model.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
    @Query(value = "SELECT * FROM ADDRESS a WHERE a.customer_id = ?1", nativeQuery = true)
    public Optional<List<Address>> getAddressByCustomerId(String customerId);
}
