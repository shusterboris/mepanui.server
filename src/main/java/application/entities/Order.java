package application.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order")
public class Order extends BasicEntity implements Serializable {
	private LocalDateTime orderDate;
	private Double price;
	private String notes;
	private OrderStatus status;
	private Long service;// relation CatItem
	private String addOptions;// from CatItem
	private Long customer;
	private Address address;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
	private Set<Answer> answers;

}
