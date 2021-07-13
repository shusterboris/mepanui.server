package application.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author innai ответ от исплнителя на заказ
 */
@Getter
@Setter
@Entity
@Table(name = "answer")

public class Answer extends BasicEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5497054988942393050L;

	@ManyToOne(fetch = FetchType.LAZY)

	@JoinColumn(name = "order_id", nullable = false)
	private Offer offer;

	private Long customerId;
	private Long executorId;
	private String notes;
	private Float price;
	private AnswerState state;
}
