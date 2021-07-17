package application.services.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import application.entities.CatItem;

@Repository
public interface CatItemDAO extends CrudRepository<CatItem, Long> {
	public Set<CatItem> findByParentKeyOrderById(Long parentKey);
}
