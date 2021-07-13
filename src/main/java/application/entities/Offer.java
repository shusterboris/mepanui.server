package application.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "offer")
public class Offer extends Address implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 3592942888058516608L;
	private LocalDateTime orderDateBegin;
	private LocalDateTime orderDateEnd;
	private Float price = (float) 0;
	@Column(name = "notes", nullable = false, length = 255)
	private String notes;
	private OrderStatus status;
	private Long serviceId;// relation CatItem
	private String addOptions;// from CatItem
	private Long customerId;
	private Long executorId;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "offer")
	private Set<Answer> answers;

}
