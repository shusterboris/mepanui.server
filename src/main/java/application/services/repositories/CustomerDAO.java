package application.services.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import application.entities.Customer;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Long> {

}
