package application.services.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import application.entities.Executor;

@Repository
public interface ExecutorDAO extends CrudRepository<Executor, Long> {

}
