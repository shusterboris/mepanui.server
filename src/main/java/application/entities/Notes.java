package application.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author innai вся переписка по заказам
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "notes")
public class Notes extends BasicEntity implements Serializable {
	private Long orderId;
	private Long executorId;
	private String note;

}
