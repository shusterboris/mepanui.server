package application.services.repositories;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import application.entities.Offer;
import application.entities.OrderStatus;


@Repository
public interface OfferDAO extends PagingAndSortingRepository<Offer, Long> {
	public Page<Offer> findByStatus(@Param("status") OrderStatus status, Pageable p);

	public Page<Offer> findByCustomerId(@Param("customerId") Long customerId, Pageable p);

	public Page<Offer> findByExecutorId(@Param("executorId") Long executorId, Pageable p);

	public Optional<Offer> findById(Long id);
}
